package jt.nio.socket.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author: jingteng
 * @date: 2020/5/18 1:26
 */
public class NettyByteBuf01 {
    public static void main(String[] args) {


        //创建一个ByteBuf
        //该对象包含了一个数组，是一个byte[]
        //在netty的buffer中，不需要进行flip，因为底层维护了readIndex和writeIndex
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

        System.out.println("buffer的容量 ： " + buffer.capacity());
        //输出1：指定索引，不会改变readIndex
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.getByte(i));
        }

        //输出2：不指定索引，是从当前的readIndex开始读取的，读取的过程中readIndex会 ++ ，知道读取完成
        while (buffer.readableBytes() > 0){
            System.out.println(buffer.readByte());
        }
    }
}
