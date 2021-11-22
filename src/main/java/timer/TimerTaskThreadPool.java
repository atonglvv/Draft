package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: draft
 * @description: 定时任务线程池实现
 * @author: atong
 * @create: 2021-11-22 21:26
 */
public class TimerTaskThreadPool {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // task to run goes here
                System.out.println("hello world");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间, 第二个参数为定时执行的时间间隔
        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }
}
