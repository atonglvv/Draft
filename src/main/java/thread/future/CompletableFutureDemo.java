package thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-12-27 22:21
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步调用没有返回值 未指定线程池
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture1");
        });
        completableFuture1.get();

        //异步调用没有返回值 指定线程池
        ExecutorService threadPool1 = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync( () -> {
            System.out.println("指定线程池： " + Thread.currentThread().getName() + "completableFuture2");
        }, threadPool1);
        completableFuture2.get();

        // 有返回值
        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture3");
            return 10;
        });
        Integer integer1 = completableFuture3.get();
        System.out.println("直接get获取completableFuture3的执行结果： " + integer1);
        // 当 completableFuture3 执行完后返回
        Integer integer = completableFuture3.whenComplete((t, u) -> {
            //t -> 返回值
            System.out.println("返回值t = " + t);
            //u -> 异常
            System.out.println("异常u = " + u);
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况： " + e.getCause() + "\t" + e.getMessage());
            return null;
        }).get();
        System.out.println("先whenComplete后get获取completableFuture3的执行结果：" + integer);
    }
}
