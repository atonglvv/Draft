package basics.innerclass.anonymity;

import basics.innerclass.member.OuterDemo;

/**
 * @program: draft
 * @description: Java 匿名内部类
 * 一个没有名字的类，是内部类的简化写法
 * 本质：其实是继承该类或者实现接口的子类匿名对象
 *
 * ​在开发的时候，会看到抽象类，或者接口作为参数。
 * 而这个时候，实际需要的是一个子类对象。
 * 如果该方法仅仅调用一次，就可以使用匿名内部类的格式简化。
 * @author: atong
 * @create: 2021-04-25 16:11
 */
public class Outer {

    public void method(){
        new Inner() {
            @Override
            public void show() {
                System.out.println("HelloWorld");
            }
        }.show();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}
