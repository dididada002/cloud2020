package jt.nio.socket.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: jingteng
 * @date: 2020/5/22 22:38
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {

    /**
     * MessageToByteEncoder 中的 write() 方法 会根据泛型进行判断是否符合类型，
     *      如果符合当前编码的类型，才会进行编码
     *      如果不符合当前定义的泛型，就会交给其他的编码器进行处理
     *
     * */


    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("进入MyLongToByteEncoder.encode ");
        System.out.println("msg = " +msg);
        out.writeLong(msg);
        out.writeLong(msg);
    }
}
