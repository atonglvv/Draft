package jvm;

/**
 * @Auther: carver
 * @Date: 2019/6/6 15:31
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Order {
    public static void m () {
        System.out.println("m()");
    }

    public static void main(String[] args) {
        Order order = null;
        order.m();
    }
}
