package thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: draft
 * @description: 通过实现Callable接口
 * @author: atong
 * @create: 2021-12-18 15:00
 */
public class CallableTask {
    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            //任务执行完毕, 返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class CallTask implements Callable<String> {

        @Override
        public String call() {
            return "hello world";
        }
    }
}
