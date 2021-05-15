package jvm.classload;

/**
 * @Auther: carver
 * @Date: 2019/1/19 19:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ClassLoaderOrder {

    public static void main(String[] args) {
        /*
         * new B() -> 第一次加载B类, B extends A 所以需要先加载A类。
         * 先加载父类(A)的静态代码块,然后加载子类(B)的静态代码块
         * 然后父类构造函数创建对象, 最后子类构造函数
         */
        A ab = new B();
        System.out.println();
        System.out.println("============");
        //第二次 new B(), AB都已经加载到JVM中, 不再需要加载。
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