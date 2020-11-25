package design.singleton.singleton07;

/**
 * @Description: Singleton07单例模式-枚举
 * @Author: atong
 * @Date: 2020-06-15
 * @Version:v1.0
 */
public class Singleton07 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton1 = Singleton.INSTANCE;
        System.out.println(singleton == singleton1);
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        singleton.sayOk();
    }
}

enum Singleton {
    INSTANCE;
    public void sayOk() {
        System.out.println("ook");
    }
}
