package thread.future;

import java.util.concurrent.*;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-06-19 22:12
 */
public class ScheduleThreadPoolExecutorDemo {
    public static void main(String[] args) {
        System.out.println("main");
        String str = ScheduleThreadPoolExecutorDemo.getStr();
        System.out.println(str);
    }

    public static String getStr() {
        System.out.println("begin");
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(5);
        executor.schedule(() -> {
            System.out.println("a");
        }, 6, TimeUnit.SECONDS);
        System.out.println("end");
        return "ook";
    }
}
