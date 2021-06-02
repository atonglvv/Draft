package basics.extendss;

import basics.extendss.Father;

/**
 * @program: draft
 * @description: child
 * @author: atong
 * @create: 2021-06-02 16:01
 */
public class Child { //extends Father {

    private Integer age;

    /**
     * 子类和父类在同一个包中时，子类可以继承父类的除private属性的所有方法和成员变量,
     * 当子类与父类不在同一个包中时，子类只能继承父类的protected和public属性的成员变量和方法。
     * 子类中定义的成员变量和父类中的成员变量同名时，子类就隐藏了继承的成员变量；
     */
//    public Child () {
//        this.age = 19;
//    }



}
