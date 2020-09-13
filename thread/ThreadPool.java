package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: carver
 * @Date: 2019/1/23 10:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ThreadPool {

    public static void main(String[] args) {

        /**
         * 创建线程池(4种)
         */
        //1创建一个单线程的线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //2创建一个固定大小的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //3创建一个可缓存的线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newScheduledThreadPool(3);


        executorService.execute(new MyRunable());
        executorService.execute(new MyRunable());

        executorService.shutdown();

    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {

    }
}
