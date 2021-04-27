package net.socket.tcp.upload;

import java.io.*;
import java.net.Socket;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-27 20:38
 */
public class TcpFileUploadClient {
    public static void main(String[] args) throws Exception {
        //客户端连接服务端8888，得到Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //创建读耽兹盘文件的输入流
        String filePath = "src\\main\\java\\net\\socket\\tcp\\upload\\xwz.jpg";
        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(filePath));

        //bytes 就是 filePath 对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流,将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //将文件对应的字节数组的内容, 写入到数据通道
        bos.write(bytes);
        bis.close();
        //设置写入数据的结束标志
        socket.shutdownOutput();

        //关闭相关流
        bos.close();
        socket.close();

    }

}
