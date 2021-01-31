package net;

import java.net.InetSocketAddress;

/**
 * @program: draft
 * @description: InetSocketAddressTest
 * @author: atong
 * @create: 2021-01-31 13:18
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("www.baidu.com", 80);
        System.out.println(inetSocketAddress);

        System.out.println("======inetSocketAddress常用方法======");
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getHostString());
        System.out.println(inetSocketAddress.getPort());
    }
}
