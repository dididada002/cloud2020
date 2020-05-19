package jt.nio.socket.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @author: jingteng
 * @date: 2020/5/19 17:30
 *
 *
 * TextWebSocketFrame：表示一个文本帧
 */
public class MyTextWebsocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        System.out.println("服务器收到消息： " + msg.text());

        //回复消息
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间： " + LocalDateTime.now() + "，收到了消息： " + msg.text()));
    }


    /**
     * 当web客户端连接后，出发该方法
     * */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //id 表示唯一的值，LongText 是唯一的，ShortText 不是唯一的
        System.out.println(ctx.channel().remoteAddress() + "handlerAdded 被调用了，LongText : " + ctx.channel().id().asLongText());
        System.out.println(ctx.channel().remoteAddress() + "handlerAdded 被调用了，ShortText : " + ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "handlerRemoved 被调用了，LongText : " + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常： " + cause.getMessage());
        ctx.close();
    }
}
