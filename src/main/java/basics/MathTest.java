package basics;

/**
 * @Auther: carver
 * @Date: 2019/1/19 16:00
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class MathTest {

    public static void main(String[] args) {

        /**
         * Math.round(11.5)的返回值是 12
         * Math.round(-11.5)的返回值是-11。
         * 四舍五入的原理是在参 数上加 0.5 然后进行下取整。
         */
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

    }
}
