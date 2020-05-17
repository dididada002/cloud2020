package jt.nio.socket.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: jingteng
 * @date: 2020/5/17 23:01
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        //加入一个netty提供的httpServerCodec
        //httpServerCodec 是netty 提供的处理http的编解码器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());

        //增加一个自定义的处理器
        pipeline.addLast("MyTestHttpServerHandler",new TestHttpServerHandler());

    }
}
