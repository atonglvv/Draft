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
            System.out.println("======根据指定主机名/域名获取ip地址对象 getByName======");
            //查询本机ip地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println("127.0.0.1 InetAddress对象 = " + inetAddress);
            //查询baiduIp地址
            InetAddress inetAddressBaidu = InetAddress.getByName("www.baidu.com");
            System.out.println("baidu InetAddress对象 = " + inetAddressBaidu);
            //获取localhost InetAddress
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println("localhost InetAddress对象 = " + localhost);

            InetAddress inetAddressByName = InetAddress.getByName("DESKTOP-KTUAU1C");
            System.out.println("InetAddress.getByName()获取InetAddress对象 = " + inetAddressByName);

            System.out.println("======获取本机InetAddress对象getLocalHost======");
            //获取本地主机
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("InetAddress.getLocalHost()获取InetAddress = " + localHost);

            //InetAddress常用方法
            System.out.println("======InetAddress常用方法======");
            System.out.println(inetAddressBaidu.getAddress());
            System.out.println(inetAddressBaidu.getCanonicalHostName());
            //获取InetAddress对象的地址 -> getHostAddress
            System.out.println(inetAddressBaidu.getHostAddress());
            //获取InetAddress对象的主机名 -> getHostName
            System.out.println(inetAddressBaidu.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
