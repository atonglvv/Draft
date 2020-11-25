package polymorphism;

/**
 * @description
 * 成员变量,静态方法看左边;
 * 非静态方法,编译看左边,运行看右边.
 * @author atong
 * @date 20:41 2020/10/29
 * @version 1.0.0.1
 **/
class Fu {
    String name = "我是父类";
    static void method1() {
        System.out.println("调用父类的m1方法");
    }
    void method2() {
        System.out.println("调用父类的m2方法");
    }
}
class Zi extends Fu {
    String name = "我是子类";
    static void method1() {
        System.out.println("调用子类的m1方法");
    }
    @Override
    void method2() {
        System.out.println("调用子类的m2方法");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.name);
        Fu.method1();
        f.method2();
        Zi z = new Zi();
        System.out.println(z.name);
        Zi.method1();
        z.method2();
    }
}