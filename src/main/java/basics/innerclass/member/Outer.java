package basics.innerclass.member;

/**
 * @program: draft
 * @description: Java 内部类之成员内部类
 * 是什么：
 * 成员内部类 —— 就是位于外部类成员位置的类
 * 特点：可以使用外部类中所有的成员变量和成员方法（包括private的）
 *
 * 怎么用：
 *   //成员内部类不是静态的：
 *   外部类名.内部类名 对象名 = new 外部类名.new 内部类名();​
 *   //成员内部类是静态的：
 *   外部类名.内部类名 对象名 = new 外部类名.内部类名();
 * @author: atong
 * @create: 2021-04-25 11:38
 */
public class Outer {
    private int age = 20;
    /** 成员位置 */
    class Inner {
        public void show() {
            System.out.println(age);
        }
    }
}
