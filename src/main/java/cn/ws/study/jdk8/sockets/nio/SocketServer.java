package cn.ws.study.jdk8.sockets.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : wssapro
 * @date Date : 2023-09-01 01:07
 */
public class SocketServer {


    public static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);



        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            if(socketChannel!=null){
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }


            for (SocketChannel channel : channelList) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1);

                int read = channel.read(byteBuffer);
                if(read>0){
                    System.out.println(new String(byteBuffer.array()));
                }
            }

        }


    }
}
