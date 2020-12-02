package thread.forSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFor {
    private static final int loopNum = 1*10;

    public static void main(String args[]) throws InterruptedException {
        ThreadFor TestThreadPool = new ThreadFor();
        long bt = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        TestThreadPool.m1(list);
        long et2 = System.currentTimeMillis();
        System.out.println("[1]耗时:"+(et2 - bt)+ "ms");
        Thread thread = new Thread();
        long at = System.currentTimeMillis();
        TestThreadPool.m2();
        long et3 = System.currentTimeMillis();
        System.out.println("[2]耗时:"+(et3 - at)+ "ms");

    }

    /**
     * 采用多线程处理，线程池管理。list每个元素开一个线程进行处理。
     * 可大大减少for循环的耗时操作。
     * 但这种情况不适合for次数较大的情形，因为每循环一次，就开辟一个线程，开销较大。
     * @param list
     */
    public void m1( List<String> list) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(list.get(i));
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        //模拟耗时操作
                        System.out.println("[1]" + Thread.currentThread().getName() + "----" + str);
                    } catch (Exception e) {
                    }
                }
            };
            pool.execute(run);

        }
        System.out.println("[1] done!");
        pool.shutdown();
    }

    /**
     * main主线程处理
     */
    public void m2() {
        AtomicInteger connectionIds = new AtomicInteger(0);
        for (int index = 0; index < loopNum; index++) {
            try {
                //模拟耗时操作
                Thread.sleep(1000);
                System.out.println("[2]" + Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("[2] done!");
    }
}
