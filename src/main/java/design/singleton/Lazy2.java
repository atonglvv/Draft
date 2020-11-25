package design.singleton;

/**
 * @Auther: carver
 * @Date: 2019/3/3 21:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 懒汉式单例模式：在类加载时不初始化。
 *               线程安全
 */
public class Lazy2 {

    private static Lazy2 lazy2;

    private Lazy2() {}

    public static synchronized Lazy2 getInstance() {
        if (lazy2 != null) {
            lazy2 = new Lazy2();
        }
        return lazy2;
    }
}
