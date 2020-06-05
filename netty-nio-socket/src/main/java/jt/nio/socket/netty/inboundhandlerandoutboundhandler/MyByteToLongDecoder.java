package jt.nio.socket.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/5/22 22:28
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /**
     *
     * 注意：decode 会根据接收到的数据，被调用多次，直到确定没有新的元素被添加到list，或者是 ByteBuf in 没有更多的可读字节为止
     *      如果 List<Object> out 不为空，就会将list的内容传递给下一个 ChannelInboundHandler 处理，该处理器的方法会被调用多次
     *
     *将入站的ByteBuf转为Long类型的数据
     * @param ctx 上下文对象
     * @param in   入站的ByteBuf
     * @param out   List集合，将解码后的数据传给下一个handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("解码器被调用");
        System.out.println(ctx.channel().hashCode());
        System.out.println(ctx.channel().id());
        //需要判断够8个字节，才能进行读取
        if (in.readableBytes() >= 8){
            out.add(in.readLong());
        }
    }
}
