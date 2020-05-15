package jt.nio.socket.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: jingteng
 * @date: 2020/5/16 0:16
 * 群聊系统的客户端：
 *
 */
public class GroupChatClient {

    //定义属性
    private final String HOST = "127.0.0.1";
    private final int PORT = 6663;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;

    public GroupChatClient() throws IOException {
        //得到选择器
        selector = Selector.open();
        //得到通道
        socketChannel = socketChannel.open(new InetSocketAddress(HOST,PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
    }

    //向服务器发送消息
    public void sendInfo(String info){
        info = userName + " 发送了消息： " +info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从服务器读取消息
    public void readInfo(){
        try {
            int select = selector.select();
            System.out.println(select);
            if (select > 0){
                System.out.println(userName + "有可用的通道");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (key.isReadable()){
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        String msg = new String(buffer.array());
                        System.out.println(msg);
                    }
                    iterator.remove();
                }
            }else {
                System.out.println("没有可用的通道。。。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //启动客户端
        GroupChatClient groupChatClient = new GroupChatClient();
        //读取消息的线程
        new Thread(){
            @Override
            public void run(){
                while (true){
                 groupChatClient.readInfo();
                try {
                    Thread.currentThread().sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }

            }
        }.start();

        //发送数据给服务器
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            groupChatClient.sendInfo(s);
        }
    }
}
