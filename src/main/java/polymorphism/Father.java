package polymorphism;

import lombok.Data;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-02-24 12:31
 */
@Data
public class Father {
    String name = "我是父类";
    static void method1() {
        System.out.println("调用父类的m1方法");
    }
    void method2() {
        System.out.println("调用父类的m2方法");
    }
}
