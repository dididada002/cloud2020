package jt.nio.socket.netty.simple;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author: jingteng
 * @date: 2020/5/17 0:58
 *
 * 1、自定义一个Handler，需要继承netty规定好的某个HandlerAdapter
 * 2、这时我们定义的Handler才能被成为一个Handler
 * 3、这个handler测试处理会引起阻塞的业务如何处理
 */
public class NettyServerHandlerTaskQueue extends ChannelInboundHandlerAdapter {


    /**
     * 读取客户端发送的数据
     * 1、ChannelHandlerContext：上下文对象，还有管道pipeline，通道channel，地址
     * 2、Object ：就是客户端发送的数据
     * 3、假设这里我们需要处理的业务会非常耗时，那么就要将这些任务加入到任务队列中，这样才不会造成阻塞
     * */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //方案1、用户自定义的普通任务

        //方案1 - 开始

        //任务的执行是有顺序的，先加入队列的先执行，执行完成后才会执行下一个任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~~~我执行完了一个耗时10秒的任务",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常 ：" + e.getMessage());
                }
            }
        });
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5_000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~~~我执行完了一个耗时5秒的任务",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常 ：" + e.getMessage());
                }
            }
        });

        //方案1 - 结束

        //方案2 ：用户自定义定时任务 ： 该任务提交到scheduleTaskQueue中（与方案1是不同的任务队列）

        //方案2 - 开始
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~~~我执行完了一个耗时10秒的定时任务",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常 ：" + e.getMessage());
                }
            }
        },5, TimeUnit.SECONDS);
        //方案2 -结束


        /*System.out.println("server ctx: " + ctx);
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息是： " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址： " + ctx.channel().remoteAddress());*/
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
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~~~我的任务执行完成了",CharsetUtil.UTF_8));
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
