package jt.nio.socket.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/5/23 0:55
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Long> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("解码器2被调用");
        System.out.println(ctx.channel().hashCode());
        System.out.println(ctx.channel().id());


        //需要判断够8个字节，才能进行读取
        /*if (in.readableBytes() >= 8){
            out.add(in.readLong());
        }*/


        //ReplayingDecoder 不用判断数据是否足够读取，内部会进行自动判断
        out.add(in.readLong());
    }
}
