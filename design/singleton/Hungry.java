package design.singleton;

/**
 * @Auther: carver
 * @Date: 2019/3/3 21:02
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 单例模式 饿汉式
 */
public class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry() {}

    public static Hungry getInstance() {
        return hungry;
    }
}
