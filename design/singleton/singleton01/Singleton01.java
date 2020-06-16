package design.singleton.singleton01;

/**
 * @Description: 单例模式-饿汉式（静态常量）
 * @Author: atong
 * @Date: 2020-06-09
 * @Version:v1.0
 */
public class Singleton01 {
    public static void main(String[] args) {
        //测试
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());

    }
}

class Singleton {
    //私有构造函数，方式外部通过new创建对象
    private Singleton () {

    }

    //类的内部创建对象
    private final static Singleton singleton = new Singleton();

    //对外暴露一个静态方法
    public static Singleton getInstance() {
        return singleton;
    }

}
