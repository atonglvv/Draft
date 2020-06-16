package design.singleton.singleton06;

/**
 * @Description: Singleton06单例模式-静态内部类
 * @Author: atong
 * @Date: 2020-06-15
 * @Version:v1.0
 */
public class Singleton06 {
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

    //静态内部类，该内部类含有一个静态属性Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外暴露一个静态方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
