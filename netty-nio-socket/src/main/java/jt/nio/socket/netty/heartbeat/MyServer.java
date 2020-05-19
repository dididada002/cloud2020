package jt.nio.socket.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author: jingteng
 * @date: 2020/5/19 11:07
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(boosGroup,workerGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel作为服务器的通道实现
                    .handler(new LoggingHandler(LogLevel.INFO)) //在boosGroup 增加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            //加入一个 netty提供的IdleStateHandler
                            /**
                             * IdleStateHandler：是netty提供的一个处理空闲状态的处理器
                             * 参数：readerIdleTime   表示多长时间没有读，就会发送一个心跳检测包
                             *      writerIdleTime  表示多长时间没有写，就会发送一个心跳检测包
                             *      allIdleTime   表示多长时间没有读写，就会发送一个心跳检测包
                             *当 IdleStateEvent 触发后，就会传递给管道的下一个handler去处理，
                             * 通过调用下一个handler的userEventTrigger，在该方法中去处理IdleStateEvent（读空闲，写空闲，读写空闲）
                             * */
                            pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));

                            //处理空闲：自定义处理器
                            pipeline.addLast(new MyServerHandler());

                        }
                    });

            System.out.println("netty 服务器启动了");


//启动服务器：绑定一个端口并且同步，生成一个ChannelFuture对象
            ChannelFuture cf = bootstrap.bind(7881).sync();

            cf.channel()
                    .closeFuture()
                    .sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
