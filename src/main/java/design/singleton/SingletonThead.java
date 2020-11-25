package design.singleton;

/**
 * @Auther: carver
 * @Date: 2019/12/28 20:43
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 多线程下单例模式
 */
public class SingletonThead {
    private static SingletonThead instance = null;
    private SingletonThead() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonThead()");
    }
    public static synchronized SingletonThead getInstance() {
        if (null == instance) {
            instance = new SingletonThead();
        }
        return instance;
    }

    public static void mian () {
        //单线程(main单线程)
//        System.out.println(SingletonThead.getInstance() == SingletonThead.getInstance());
//        System.out.println(SingletonThead.getInstance() == SingletonThead.getInstance());
//        System.out.println(SingletonThead.getInstance() == SingletonThead.getInstance());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonThead.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
