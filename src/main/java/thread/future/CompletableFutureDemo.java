package thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-12-27 22:21
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步调用没有返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync( () -> {
            System.out.println(Thread.currentThread().getName() + "completableFuture1");
        });
        completableFuture1.get();

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName() + "completableFuture1");
            return 10;
        });
        Integer integer = completableFuture2.whenComplete((t, u) -> {
            //t -> 返回值
            System.out.println("t = " + t);
            //u -> 异常
            System.out.println("u = " + u);
        }).get();

        System.out.println(integer);

    }
}
