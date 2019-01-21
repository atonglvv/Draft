package jvm;

/**
 * @Auther: carver
 * @Date: 2019/1/19 19:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ClassLoaderOrder {

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }


}


class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}