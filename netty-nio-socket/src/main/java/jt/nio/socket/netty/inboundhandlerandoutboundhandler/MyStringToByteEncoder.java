package jt.nio.socket.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: jingteng
 * @date: 2020/5/22 22:38
 */
public class MyStringToByteEncoder extends MessageToByteEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        System.out.println("MyStringToByteEncoder.encode ");
        System.out.println("msg = " +msg);
//        ctx.writeAndFlush(msg);
        out.writeBytes(msg.getBytes());
    }
}
