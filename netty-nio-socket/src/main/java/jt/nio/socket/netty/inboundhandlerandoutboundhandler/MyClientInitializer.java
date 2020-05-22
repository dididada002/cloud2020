package jt.nio.socket.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author: jingteng
 * @date: 2020/5/22 22:36
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();


        //todo 处理器的加入顺序进行分析

        //加入出站的handler，对数据进行一个编码
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyStringToByteEncoder());

        //加入自定义handler
        pipeline.addLast(new MyClientHandler());
    }
}
