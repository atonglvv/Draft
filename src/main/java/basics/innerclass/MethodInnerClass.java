package basics.innerclass;

/**
 * @program: draft
 * @description: 方法里内部类
 * @author: atong
 * @create: 2022-10-10 22:06
 */
public class MethodInnerClass {

    public void test() {
        // 下面这行代码会报错, 因为 test方法里的代码是顺序执行
        // Test t = new Test();
        class Test {
            /**
             * 请问number是常量还是变量？ 常量！
             * 当方法执行完后,出栈, 内存销毁
             * 但, 内部类Test可能还存在外部引用
             * 如果外部引用修改内部类的变量就有悖论
             * 所以number必须是final
             */
            int number = 3;

        }
        Test t = new Test();
    }



}
