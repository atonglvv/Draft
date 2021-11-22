package timer;

/**
 * @program: draft
 * @description: 多线程实现定时任务
 * @author: atong
 * @create: 2021-11-22 21:18
 */
public class TimerTask {
    static int count = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {
                try {
                    //实现定时任务
                    Thread.sleep(1000);
                    System.out.println("定时任务需要分批执行。。。count= " + ++count);
                } catch (Exception e) {
                    //handle exception
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
