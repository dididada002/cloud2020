package jt.nio.socket.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author: jingteng
 * @date: 2020/5/18 23:30
 *
 * netty模拟群聊系统：客户端
 */
public class GroupChatClient {

    private final String host;
    private final int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException {
        //客户端需要一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        //创建客户端启动对象
        Bootstrap bootstrap = new Bootstrap();
        try {
            //设置参数
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("decoder",new StringDecoder())//加入解码器
                                    .addLast("encoder",new StringEncoder())//加入编码器
                                    .addLast(new GroupChatClientHandler());
                        }
                    });

            //启动客户端去连接服务器端
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

            Channel channel = channelFuture.channel();

            System.out.println(channelFuture.channel().remoteAddress() +"客户端准备好了。。。");

            //发送消息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }
            //给关闭通道进行监听
            channel.closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatClient("127.0.0.1",7332).run();
    }
}
