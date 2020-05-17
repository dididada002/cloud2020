package jt.nio.socket.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: jingteng
 * @date: 2020/5/17 0:58
 *
 * 1、自定义一个Handler，需要继承netty规定好的某个HandlerAdapter
 * 2、这时我们定义的Handler才能被成为一个Handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 读取客户端发送的数据
     * 1、ChannelHandlerContext：上下文对象，还有管道pipeline，通道channel，地址
     * 2、Object ：就是客户端发送的数据
     * */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx: " + ctx);
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息是： " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址： " + ctx.channel().remoteAddress());
    }


    /**
     * 数据读取完毕
     * */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        /**
         * 将数据写入到缓存，并刷新
         * 对这个发送的数据进行编码
         * */
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~~~",CharsetUtil.UTF_8));
    }


    /**
     * 处理异常：一般需要关闭通道
     *
     * */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
