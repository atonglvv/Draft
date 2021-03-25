package polymorphism;

/**
 * @description
 * 成员变量,静态方法看左边;
 * 非静态方法,编译看左边,运行看右边.
 * @author atong
 * @date 20:41 2020/10/29
 * @version 1.0.0.1
 **/
public class Polymorphism {
    public static void main(String[] args) {
        Father father = new Child();
        System.out.println(father.name);
        Father.method1();
        father.method2();
        Child child = new Child();
        System.out.println(child.name);
        Child.method1();
        child.method2();
    }
}