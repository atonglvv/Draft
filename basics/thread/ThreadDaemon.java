package basics.thread;

/**
 * @Auther: carver
 * @Date: 2019/1/22 13:00
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        MyThread tr = new MyThread();
        Thread t = new Thread(tr);
        //线程可分为守护线程与非守护线程，当进程中没有非守护线程时，JVM会退出
        //把线程t设为守护线程
        t.setDaemon(true);
        t.start();

        System.out.println(t.isDaemon());

        for (int i = 0; i < 50; i++) {
            System.out.println("main--" + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
