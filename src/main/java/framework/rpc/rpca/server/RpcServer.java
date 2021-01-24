package framework.rpc.rpca.server;

import framework.rpc.domain.entity.User;
import framework.rpc.service.UserService;
import framework.rpc.service.impl.UserServiceImpl;

import java.io.*;
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
                process(socket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void process (Socket socket) throws IOException {
        //
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Long userId = inputStream.readLong();

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        UserService userService = new UserServiceImpl();
        User user = userService.getUser(userId);
        outputStream.writeObject(user.toString());
        outputStream.flush();
    }
}
