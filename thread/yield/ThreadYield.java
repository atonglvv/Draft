package thread.yield;

/**
 * 线程礼让：将线程从运行状态转为就绪状态
 */
public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        Yield yield = new Yield();
        new Thread(yield, "a").start();
        new Thread(yield, "b").start();
    }
}
class Yield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); //线程礼让
        System.out.println(Thread.currentThread().getName() + "线程结束执行");
    }
}
