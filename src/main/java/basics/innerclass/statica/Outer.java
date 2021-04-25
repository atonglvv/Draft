package basics.innerclass.statica;

/**
 * @program: draft
 * @description:
 * static是不能用来修饰类的, 但是成员内部类可以看做外部类中的一个成员, 所以可以用static修饰,
 * 这种用static修饰的内部类我们称作静态内部类, 也称作嵌套内部类.
 * 特点：不能使用外部类的非static成员变量和成员方法
 *
 * 非静态内部类编译后会默认的保存一个指向外部类的引用，而静态类却没有。
 *
 * 即使没有外部类对象，也可以创建静态内部类对象，而外部类的非static成员必须依赖于对象的调用，静态成员则可以直接使用类调用，不必依赖于外部类的对象，
 * 所以静态内部类只能访问静态的外部属性和方法。
 * @author: atong
 * @create: 2021-04-25 15:49
 */
public class Outer {
    int age = 10;
    static int age2 = 20;
    public  Outer() {
    }

    static class Inner {
        public void method() {
            //错误
            //System.out.println(age);
            //正确
            System.out.println(age2);
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.method();
    }
}
