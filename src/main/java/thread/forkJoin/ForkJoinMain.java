package thread.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @program: draft
 * @description: ForkJoinDemo执行类
 * @author: atong
 * @create: 2020-11-17 10:44
 */
public class ForkJoinMain {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new ForkJoinDemo(1,100));
        try {
            Integer result = forkJoinTask.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }
}
