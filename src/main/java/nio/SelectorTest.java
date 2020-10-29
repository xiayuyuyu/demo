package nio;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/9/14 21:19
 */
public class SelectorTest {
    public static void main(String[] args) throws Exception {
        //获取socket通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置为非阻塞模式
        socketChannel.configureBlocking(false);
        //建立连接，非阻塞模式下，该方法可能在连接建立之前就返回了
        String url = "www.baidu.com";
        InetAddress inetAddress = InetAddress.getByName(url);
        socketChannel.connect(new InetSocketAddress(inetAddress.getHostAddress(), 80));
        Selector selector = Selector.open();
//        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (!socketChannel.finishConnect()) {
            System.out.println("漫长的等待===========");
        }
        System.out.println("连接建立" + socketChannel.getRemoteAddress());

        int count = doGet(socketChannel, url);
        System.out.println("写入数据数量:" + count);
        readDataFromServer(socketChannel);
    }

    private static void readDataFromServer(SocketChannel socketChannel) throws Exception {
        int read = 0;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("开始读...");

        while (true) {
            buffer.clear();
            read = socketChannel.read(buffer);
            if (read == -1) {
                break;
            }
            System.out.print(new String(buffer.array(), 0, read, "UTF-8"));
            Thread.sleep(10);
        }
        System.out.println("读完成");

        System.out.println("\n#结束#");
    }

    private static int doGet(SocketChannel socketChannel, String url) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("GET / HTTP/1.1\r\n");
        sb.append("Host: " + url + "\r\n");
        sb.append("\r\n");

        ByteBuffer buffer = ByteBuffer.wrap(sb.toString().getBytes("UTF-8"));
        int bytesWrite = socketChannel.write(buffer);
        return bytesWrite;

    }
}
