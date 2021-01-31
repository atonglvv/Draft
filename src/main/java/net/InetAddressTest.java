package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: draft
 * @description: InetAddress测试类
 * @author: atong
 * @create: 2021-01-31 12:48
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //查询本机ip地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);
            //查询baiduIp地址
            InetAddress inetAddressBaidu = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddressBaidu);
            //获取localhost InetAddress
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println(localhost);
            //获取本地主机
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            //InetAddress常用方法
            System.out.println("======InetAddress常用方法======");
            System.out.println(inetAddressBaidu.getAddress());
            System.out.println(inetAddressBaidu.getCanonicalHostName());
            System.out.println(inetAddressBaidu.getHostAddress());
            System.out.println(inetAddressBaidu.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
