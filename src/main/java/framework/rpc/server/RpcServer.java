package framework.rpc.server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: draft
 * @description: Rpc服务端
 * @author: atong
 * @create: 2021-01-22 11:41
 */
public class RpcServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject("hello world");
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
