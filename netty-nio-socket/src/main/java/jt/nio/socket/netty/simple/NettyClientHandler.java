package jt.nio.socket.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: jingteng
 * @date: 2020/5/17 16:05
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    /**
     * 当通道就绪就会触发该方法
     * */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client : " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,服务端： 汪汪", CharsetUtil.UTF_8));
    }


    /**
     * 当通道有读取事件时，就会触发
     * */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器回复的消息： " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器的地址 ： " + ctx.channel().remoteAddress());
    }


    /**
     * 处理异常
     * */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
