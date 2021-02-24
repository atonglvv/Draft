package polymorphism;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-02-24 12:31
 */
public class Child extends Father {
    String name = "我是子类";
    static void method1() {
        System.out.println("调用子类的m1方法");
    }
    @Override
    void method2() {
        System.out.println("调用子类的m2方法");
    }
}
