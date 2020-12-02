package basics;

/**
 * @Auther: carver
 * @Date: 2019/1/19 15:51
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class IntegerCacheTest {

    public static void main(String[] args) {

        /**
         * 简单的说，如果整型字面量的值在-128 到 127 之间，那么不会 new 新的Integer 对象，
         * 而是直接 引用常量池中的 Integer 对象，
         * 所以上面的面试题中 f1==f2的结果是 true，而 f3==f4 的结果是 false。
         */
        Integer f1 = 10, f2 = 10, f3 = 200, f4 = 200;
        System.out.println(f1.equals(f2));
        System.out.println(f3.equals(f4));

    }
}
