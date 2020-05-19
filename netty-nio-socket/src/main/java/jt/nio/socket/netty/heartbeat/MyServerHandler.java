package jt.nio.socket.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author: jingteng
 * @date: 2020/5/19 17:01
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     *
     * @param ctx 上下文
     * @param evt  事件
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()){
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + "---超时事件---" + eventType);

            //根据 业务来对相应的事件进行处理，也可以调整心跳检测空闲事件的时间
        }
    }
}
