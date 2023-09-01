package cn.ws.study.jdk8.sockets.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author : wssapro
 * @date Date : 2023-09-01 00:52
 */
public class SocekClient {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);

        while (true){

            Socket socket = serverSocket.accept();

            handleSocket(socket);
        }

    }

    public static void handleSocket(Socket socket) throws IOException {

        byte[] buff = new byte[1024];

        int read = socket.getInputStream().read(buff);
        if(read>0){
            System.out.println(new String(buff));
        }

    }
}
