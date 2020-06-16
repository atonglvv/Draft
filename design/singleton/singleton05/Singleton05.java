package design.singleton.singleton05;

/**
 * @Description: Singleton05单例模式-双重检查（Double-Check）
 * @Author: atong
 * @Date: 2020-06-15
 * @Version:v1.0
 */
public class Singleton05 {
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

    //类的内部声明变量
    //volatile防止指令重排
    private static volatile Singleton singleton;

    //对外暴露一个静态方法，当调用该方法时，才去创建实例（singleton）
    //加入双重检查，解决线程安全问题，同时支持Lazy Loading，同时保证了效率
    //推荐使用
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}