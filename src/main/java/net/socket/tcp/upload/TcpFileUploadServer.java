package net.socket.tcp.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-27 20:38
 */
public class TcpFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1。服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听.... ");
        //2。等待连接
        Socket socket = serverSocket.accept();
        //3。读取客户端发送的数据
        //通过Socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //4。将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "src\\main\\java\\net\\socket\\tcp\\upload\\xwz1.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        //关闭其他资源
        bis.close();
        socket.close();
        serverSocket.close();


    }
}
