package net.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: draft
 * @description:
 * 1.编写一个服务端, 和一个客户端
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务端,发送"hello, server"，并接收服务器端回发的"hello,client",再退出
 * 4.服务器端接收到客户端发送的信息,输出,并发送"hello, client",再退出
 * @author: atong
 * @create: 2021-04-24 20:59
 */
@SuppressWarnings("all")
public class Tcp1Client {
    public static void main(String[] args) {
        try {
            //1.建立远程连接
            Socket socket = new Socket("127.0.0.1",9999);
            System.out.println("客户端 socket返回 = " + socket.getClass());
            //2.得到和socket对象关联的输出流对象
            OutputStream outputStream = socket.getOutputStream();
            //3．通过输出流，写入数据到数据通道
            outputStream.write("hello, world".getBytes());
            //设置写入结束标记
            socket.shutdownOutput();
            //4.获取和socket关联的输入流。读取数据(字节)，并显示
            InputStream inputStream = socket.getInputStream();
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
            }

            //5．关闭流对象和socket，必须关闭
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("客户端退出...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
