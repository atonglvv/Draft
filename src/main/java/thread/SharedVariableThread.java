package thread;

/**
 * @Auther: carver
 * @Date: 2019/1/21 16:47
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 多个线程之间共享变量线程不安全的情况
 */
public class SharedVariableThread extends Thread{

    private int count = 5;

    @Override
    public /*synchronized*/  void run() {
        super.run();
        synchronized(this) {
            count--;
            try {
                //sleep -> 线程不会丢失任何显示器的所有权
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        SharedVariableThread sharedVariableThread = new SharedVariableThread();

        Thread a = new Thread(sharedVariableThread, "A");
        Thread b = new Thread(sharedVariableThread, "B");
        Thread c = new Thread(sharedVariableThread, "C");
        Thread d = new Thread(sharedVariableThread, "D");
        Thread e = new Thread(sharedVariableThread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
