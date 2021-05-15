package jvm.classload;

/**
 * @program: draft
 * @description: 类加载-初始化阶段
 * @author: atong
 * @create: 2021-05-13 23:18
 */
public class Initialization {
    public static void main(String[] args) {
        //1.加载阶段 IB类, 并生成IB的class对象
        //2.链接阶段 静态变量 num = 0
        //3.初始化阶段  依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并进行合并。
        /**
         * 收集：
         *  clinit() {
         *      System.out.println("IB 静态代码块被执行");
         *      num = 300;
         *      num = 100;
         *  }
         * 合并：
         *      num = 100
         */
        new IB();
        System.out.println("===================");
        //调用类的静态变量，会触发类的加载
        System.out.println(IB.num);
    }
}

class IB {
    static {
        System.out.println("IB 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public IB() {
        System.out.println("IB()构造器被执行");
    }
}
