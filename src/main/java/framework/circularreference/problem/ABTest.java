package framework.circularreference.problem;

/**
 * @program: draft
 * @description:
 * 循环依赖问题是什么？
 * 如下测试类, 会 StackOverflowError
 * 注意：这样的循环依赖代码是没法解决的。
 * @author: atong
 * @create: 2021-05-07 10:08
 */
public class ABTest {
    public static void main(String[] args) {
        new ClazzA();
    }
}
