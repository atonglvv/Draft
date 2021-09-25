package jvm.classload;

import sun.security.ec.CurveDB;

import java.net.URL;

/**
 * @program: draft
 * @description: 加载路径
 * @author: atong
 * @create: 2021-09-24 23:38
 */
public class LoadPath {
    public static void main(String[] args) {
        System.out.println("************启动类加载器************");
        //获取BootstrapCLassLoader能够加载的api的路径
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        System.out.println("************查看类加载器-引导类加载器************");
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("************扩展类加载器************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:
        System.out.println("************查看类加载器-扩展类加载器************");
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
