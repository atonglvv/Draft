package net;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @program: draft
 * @description: NetworkInterface Test
 * 在使用 Java 开发网络程序时，有时候我们需要知道本机在局域网中的 IP 地址。
 * 很常见的做法是调用本地命令(比如 Windows 上的 ipconfig 命令和 Linux 上的 ifconfig),接着解析本地命令的输出,最后得到本机在局域网内的IP地址。
 * 很明显，这种做法不够方便，也不够 Java。于是引出了 Java 在 JDK1.4 的时候添加的一个类： NetworkInterface 。
 * @author: atong
 * @create: 2021-04-16 13:55
 */
public class NetworkInterfaceTest {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            System.out.println(networkInterfaces.toString());
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                System.out.println(ni.toString());
                Enumeration<InetAddress> allAddress = ni.getInetAddresses();
                System.out.println("NetworkInterface.getInetAddresses() = " + allAddress.toString());
                while (allAddress.hasMoreElements()) {
                    InetAddress address = allAddress.nextElement();
                    if (address.isLoopbackAddress()) {
                        System.out.println("LoopbackAddress");
                    }
                    if (address instanceof Inet6Address) {
                        System.out.println("Inet6Address");
                    }
                    String hostAddress = address.getHostAddress();
                    System.out.println(hostAddress);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
