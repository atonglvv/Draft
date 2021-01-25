package framework.rpc.rpcc.client;

import framework.rpc.domain.entity.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @program: draft
 * @description: rpc 客户端 stock处理流程提取
 * @author: atong
 * @create: 2021-01-25 19:47
 */
public class Stub {
    public User getUser(Integer id) {
        try {
            //1.建立远程连接
            Socket socket = new Socket("127.0.0.1",8888);
            //2.服务端参数
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeLong(id);
            outputStream.flush();

            //3.接收服务端返回的结果
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) inputStream.readObject();

            //资源关闭
            inputStream.close();
            outputStream.close();
            socket.close();

            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return new User();
        }
    }
}
