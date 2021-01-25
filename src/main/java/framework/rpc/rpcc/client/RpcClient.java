package framework.rpc.rpcc.client;

import framework.rpc.domain.entity.User;

/**
 * @program: draft
 * @description: Rpc客户端 [客户端屏蔽stock逻辑]
 * @author: atong
 * @create: 2021-01-22 09:54
 */
public class RpcClient {

    public static void main(String[] args) {
        Stub stub = new Stub();
        User user = stub.getUser(1);
        String name = user.getName();
        System.out.println("name = " + name);
        System.out.println(user.toString());
    }
}
