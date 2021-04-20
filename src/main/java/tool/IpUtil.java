package tool;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @description  IP地址工具类
 * 参考 net
 * @author atong
 * @date 16:54 2021/4/19
 * @version 1.0.0.1
 **/
public class IpUtil {

	/**
	 * getLocalhostIp(获取本机ip地址)
	 * @return String
	 */
	public static String getLocalhostIp() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			return null;
		}
		return ip;
	}
	
	public static List<String> getIpAddrs() throws Exception {
		List<String> IPs = new ArrayList<String>();
		Enumeration<NetworkInterface> allNetInterfaces = null;
		allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			Enumeration<?> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address && ip.getHostAddress().indexOf(".") != -1) {
					IPs.add(ip.getHostAddress());
				}
			}
		}
		return IPs;
	}    		

	/**
	 * 兼容Linux系统
	 * @return String
	 */
	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface
					.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				Enumeration<?> e2 = ni.getInetAddresses();
				while (e2.hasMoreElements()) {
					InetAddress ia = (InetAddress) e2.nextElement();
					if (ia instanceof Inet6Address) {
						continue;
					}
					if (!ia.isLoopbackAddress()) {
						ip = ia.getHostAddress();
						break;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			return "";
		}
		return ip;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(IpUtil.getLocalhostIp());
		System.out.println(IpUtil.getIpAddrs());
		System.out.println(IpUtil.getLocalIP());
	}

}
