package jt.nio.socket.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: jingteng
 * @date: 2020/5/15 23:42
 * 群聊系统的服务器端：
 *      服务器启动并监听端口
 *      服务器接收客户端信息，并实现转发
 */
public class GroupChatServer {

    //定义属性
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 6663;

    public GroupChatServer() {
        try {
            //得到选择器
            selector = Selector.open();
            //得到通道
            serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            //设定非阻塞
            serverSocketChannel.configureBlocking(false);
            //注册监听
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        try {
            while (true){
                int count = selector.select();
                if (count > 0){//有事件需要处理
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()){
                        //取出selectionKey
                        SelectionKey selectionKey = iterator.next();
                        //处理事件
                        if (selectionKey.isAcceptable()){//连接事件
                            //生成连接
                            SocketChannel accept = serverSocketChannel.accept();
                            //设置为非阻塞
                            accept.configureBlocking(false);
                            //注册到选择器：事件是读
                            accept.register(selector,SelectionKey.OP_READ);
                            System.out.println(accept.getRemoteAddress() + "  上线了！！！");

                        } else if (selectionKey.isReadable()) {//读取事件
                            //读取消息并转发
                            redaData(selectionKey);

                        }

                        //手动从集合中删除当前的SelectionKey，防止重复操作
                        iterator.remove();
                    }

                }else {
                    System.out.println("等待中。。。");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    //读取客户端消息
    private void redaData(SelectionKey key){
        //定义通道
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //将通道中的数据读取到buffer中
            int count = socketChannel.read(buffer);
            if (count > 0){
                //打印通道中的数据
                String msg = new String(buffer.array());
                System.out.println("客户端发来消息： " + msg);

                //向其他客户端转发消息
                sendInfoToOtherClient(msg , socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + "  离线了。。。");
                //取消注册
                key.cancel();
                //关闭通道
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    //转发消息给其他客户端
    private void sendInfoToOtherClient(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中。。。。");
        for (SelectionKey key : selector.keys()) {
            //通过key取出通道
            Channel targetChannel = key.channel();
            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self){
                //转型
                SocketChannel targetSocketChannel = (SocketChannel) targetChannel;

                //将消息写入通道
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                targetSocketChannel.write(buffer);
            }
        }

    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
