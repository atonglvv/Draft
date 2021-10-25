package jvm;

/**
 * @program: draft
 * @description: 栈上分配测试
 * 没有开启逃逸分析：
 * -Xmx256m -Xms256m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * 开启逃逸分析：
 * -Xmx256m -Xms256m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * @author: atong
 * @create: 2021-10-25 23:14
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        //查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (end - start) + " ms");
        //为了方便查看堆内存中对象个数，线程sLeep
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User( );
    }

    static class User{}

}
