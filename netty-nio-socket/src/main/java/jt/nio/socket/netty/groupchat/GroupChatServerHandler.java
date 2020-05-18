package jt.nio.socket.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * @author: jingteng
 * @date: 2020/5/18 22:55
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个channelGroup，管理所有的channel
    //GlobalEventExecutor.INSTANCE 是全局的事件执行其，是一个单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * handlerAdded表示连接建立，一旦连接建立，第一个被执行
     * 将当前channel加入到channelGroup
     * */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        /**
         * 将该客户端加入聊天的信息推送给其他在线的客户端
         *
         * 该方法会将 channelGroup 中所有的channel 遍历，并发送消息，不用我们自己遍历
         * */
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress() + " " +LocalDateTime.now() + " 加入聊天\n");
        channelGroup.add(channel);
    }

    /**
     * 表示channel处于活动状态
     * */

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+ " " +LocalDateTime.now() + " 上线了~~");
    }

    /**
     * 表示channel处于不活动状态
     * */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+ " " +LocalDateTime.now() + " 离线了~~");
    }

    /**
     * 断开连接
     * */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress()+ " " +LocalDateTime.now() + " 离开聊天\n");
        System.out.println("channelGroup size : " + channelGroup.size());
    }


    /**
     * 读取数据
     * */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //当前channel
        Channel channel = ctx.channel();

        //遍历channelGroup，根据不同的情况，发送不同的消息
        channelGroup.forEach(ch -> {
            if (channel != ch){//不是当前的channel，发送消息
                ch.writeAndFlush("【客户端】" + channel.remoteAddress()+ " " +LocalDateTime.now() + " 发送了消息 ： " + msg + "\n");
            }else {//当前的channel
                ch.writeAndFlush("【自己发送给自己】 ：" +LocalDateTime.now() + " "+ msg + "\n");
            }
        });
    }


    /**
     * 捕获异常
     * */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
