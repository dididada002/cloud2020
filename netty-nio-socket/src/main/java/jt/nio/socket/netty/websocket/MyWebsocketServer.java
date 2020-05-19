package jt.nio.socket.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: jingteng
 * @date: 2020/5/19 17:16
 */
public class MyWebsocketServer {


    public static void main(String[] args) throws Exception{
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

                            //添加httpd的编码和解码器
                            pipeline.addLast(new HttpServerCodec());

                            //因为是以 块 的方式写，添加 ChunkedWriteHandler 处理器
                            pipeline.addLast(new ChunkedWriteHandler());

                            /**
                             *http数据在传输中是分段的，HttpObjectAggregator 就是可以将多个端聚合
                             * 分段：当浏览器发送大量数据时，就会发送多次http请求
                             * */
                            pipeline.addLast(new HttpObjectAggregator(8191));


                            /**
                             * WebSocketServerProtocolHandler 的核心功能是将http协议s升级为 ws 协议，保持长连接
                             *
                             * 对应websocket：它的数据是以 帧 （frame）的形式传递的
                             * 浏览器请求时： ws://localhost:7881/hello
                             *
                             * */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            /**
                             * 自定义处理器：处理业务
                             * */
                            pipeline.addLast(new MyTextWebsocketFrameHandler());

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
