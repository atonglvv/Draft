package design.singleton;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/3/3 20:56
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 懒汉式单例模式：在类加载时不初始化。
 *               线程不安全
 */
public class Lazy {

    private static Lazy lazy;

    private Lazy() {}

    public static Lazy getInstance() {
        if (lazy != null) {
            lazy = new Lazy();
        }
        return lazy;
    }

}
