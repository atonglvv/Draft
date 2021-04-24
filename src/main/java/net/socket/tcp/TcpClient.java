package net.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: draft
 * @description: Java Socket Tcp Client
 * 发送 “hello world" 给服务端
 * @author: atong
 * @create: 2021-01-31 14:57
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            //1.建立远程连接
            Socket socket = new Socket("127.0.0.1",9999);
            System.out.println("客户端 socket返回 = " + socket.getClass());
            //2.得到和socket对象关联的输出流对象
            OutputStream outputStream = socket.getOutputStream();
            //3．通过输出流，写入数据到数据通道
            outputStream.write("hello, world".getBytes());
            //4．关闭流对象和socket，必须关闭
            outputStream.close();
            socket.close();
            System.out.println("客户端退出...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
