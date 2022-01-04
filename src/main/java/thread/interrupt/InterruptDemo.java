package thread.interrupt;


/**
 * @program: draft
 * @description: Interrupt Demo
 * @author: atong
 * @create: 2022-01-02 21:27
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    System.out.println("被打断了，退出循环");
                    break;
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000);
        System.out.println("interrupt");
        t1.interrupt();
    }
}
