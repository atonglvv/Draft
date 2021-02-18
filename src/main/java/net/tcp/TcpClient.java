package net.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @program: draft
 * @description: TCP Client
 * @author: atong
 * @create: 2021-01-31 14:57
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            //1.建立远程连接
            Socket socket = new Socket("127.0.0.1",8888);
            //2.发送消息 IO流

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
