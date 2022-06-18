package thread.future;

import java.util.concurrent.*;

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

        System.out.println("========分界线========");
        // 有返回值
        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture3");
            // 睡眠3s
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        // 体现异步
        System.out.println("main线程先去忙其他的");

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


        System.out.println("========分界线========");

        CompletableFuture<Integer> completableFuture4 = CompletableFuture.supplyAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture3");
            return 1;
        }).thenApply(f -> {
            return f + 1;
        }).thenApply(f -> {
            return f + 1;
        }).whenComplete((t, u) -> {
            //t -> 返回值
            System.out.println("返回值t = " + t);
            //u -> 异常
            System.out.println("异常u = " + u);
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况： " + e.getCause() + "\t" + e.getMessage());
            return null;
        });

        System.out.println("========分界线========");

        CompletableFuture<Integer> completableFuture5 = CompletableFuture.supplyAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture3");
            return 1;
        }).handle((f, e) -> {
            return f + 1;
        }).handle((f, e) -> {
            return f + 1;
        }).whenComplete((t, u) -> {
            //t -> 返回值
            System.out.println("返回值t = " + t);
            //u -> 异常
            System.out.println("异常u = " + u);
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况： " + e.getCause() + "\t" + e.getMessage());
            return null;
        });

        System.out.println("========分界线========");

        CompletableFuture.supplyAsync( () -> {
            System.out.println("没有指定线程池： " + Thread.currentThread().getName() + "completableFuture3");
            return 1;
        }).handle((f, e) -> {
            return f + 1;
        }).handle((f, e) -> {
            return f + 1;
        }).thenAccept(System.out::println);

        System.out.println("========分界线========applyToEither");
        CompletableFuture<String> completableFuture6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("completableFuture6 come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completableFuture6";
        });

        CompletableFuture<String> completableFuture7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("completableFuture7 come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completableFuture7";
        });

        CompletableFuture<String> result = completableFuture6.applyToEither(completableFuture7, f -> {
            return f + " is winer";
        });
        String resultStr = result.get();
        System.out.println("谁更快用谁 ： " + resultStr);


        System.out.println("========分界线========applyToEither");
        CompletableFuture<String> completableFuture8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("completableFuture8 come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completableFuture8";
        });

        CompletableFuture<String> completableFuture9 = CompletableFuture.supplyAsync(() -> {
            System.out.println("completableFuture9 come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "completableFuture9";
        });

        CompletableFuture<String> resulta = completableFuture8.thenCombine(completableFuture9, (a,b) -> {
            return a + " " + b;
        });
        String resultaStr = resulta.get();
        System.out.println("合并两个结果集 ： " + resultaStr);

    }
}
