package basics.innerclass.local;

/**
 * @program: draft
 * @description: Java 局部内部类
 * 局部内部类 —— 就是定义在一个方法或者一个作用域里面的类
 * 特点：主要是作用域发生了变化，只能在自身所在方法和属性中被使用
 * @author: atong
 * @create: 2021-04-25 15:00
 */
public class Outer {
    private int age = 20;
    public void method() {
        final int age2 = 30;
        class Inner {
            public void show() {
                System.out.println(age);
                //从内部类中访问方法内变量age2，需要将变量声明加final修饰。
                System.out.println(age2);
            }
        }
        Inner i = new Inner();
        i.show();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}
