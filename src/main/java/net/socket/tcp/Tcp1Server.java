package net.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: draft
 * @description:
 * 1.编写一个服务端, 和一个客户端
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务端,发送"hello, server"，并接收服务器端回发的"hello,client",再退出
 * 4.服务器端接收到客户端发送的信息,输出,并发送"hello, client",再退出
 * @author: atong
 * @create: 2021-04-24 21:08
 */
@SuppressWarnings("all")
public class Tcp1Server {
    public static void main(String[] args) throws IOException {
        // 1.在本机的9999端口监听，等待连接
        // 细节:要求在本机没有其它服务在监听9999端口
        //ServerSocket可以通过 accept()返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听.等待连接...");
        //2．当没有客户端连接9999端口时，程序会阻塞，等待连接
        // 如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println( "socket = " + socket. getClass());
        //3，通过socket.getInputStream()读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //4。IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            //根据读取到的实际长度，显示内容.
            System.out.println(new String(buf, 0, readLen));
        }
        //5。获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("helLo,client".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();

        //6.关闭流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
