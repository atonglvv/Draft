package proxy.dynamicproxy;

import proxy.Play;
import proxy.PlayLoL;

import java.lang.reflect.Proxy;

/**
 * @program: draft
 * @description: 动态代理
 * @author: atong
 * @create: 2021-01-27 10:43
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Play play = new PlayLoL();
        // 处理类和真实角色绑定
        PlayHandler playHandler = new PlayHandler(play);
        // 开启将代理类class文件保存到本地模式，平时可以省略
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 动态代理生成代理对象$Proxy0
        Object o = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{Play.class}, playHandler);
        // 调用的其实是invoke()
        ((Play)o).play();
    }
}
