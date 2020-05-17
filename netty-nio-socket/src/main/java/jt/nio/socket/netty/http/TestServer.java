package jt.nio.socket.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: jingteng
 * @date: 2020/5/17 23:00
 * netty实现http服务
 */
public class TestServer {
    public static void main(String[] args) throws Exception{
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup,workerGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel作为服务器的通道实现
                    .childHandler(new TestServerInitializer());

            //启动服务器：绑定一个端口并且同步，生成一个ChannelFuture对象
            ChannelFuture cf = bootstrap.bind(7799).sync();

            cf.channel()
                    .closeFuture()
                    .sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
