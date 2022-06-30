package thread.threadLocal;

import java.util.stream.IntStream;

/**
 * @program: Draft
 * @description: 为什么InheritableThreadLocal
 * @author: atong
 * @create: 2022-06-30 16:31
 */
public class WhyInheritableThreadLocal {
    public static void main(String[] args) {
        // 使用 ThreadLocal 子线程拿不到 父线程的 threadLocal
        // ThreadLocal threadLocal = new ThreadLocal();
        InheritableThreadLocal threadLocal = new InheritableThreadLocal();
        IntStream.range(0,10).forEach(i -> {
            //每个线程的序列号，希望在子线程中能够拿到
            threadLocal.set(i);
            //这里来了一个子线程，我们希望可以访问上面的threadLocal
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}