package jvm.classload;

import java.sql.DriverManager;

/**
 * @program: draft
 * @description: 获取ClassLoader方式
 * @author: atong
 * @create: 2021-09-25 21:02
 */
public class ObtainClassLoader {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Class.forName("java.lang.String" ).getClassLoader();
            System.out.println(classLoader);

            ClassLoader classLoader1 = Thread.currentThread( ).getContextClassLoader();
            System.out.println(classLoader1);

            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader( ).getParent();
            System.out.println(classLoader2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
