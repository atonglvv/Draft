package basics.thread;

/**
 * @Auther: carver
 * @Date: 2019/1/22 08:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:  使用interrupt方法来中断线程，设置一个中断状态(标记)
 *                或者，也可以使用自定义标记的方式
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        MyThreada myThread = new MyThreada();
        Thread t = new Thread(myThread);
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main - " + i);
            if (i == 20) {
                //中断状态
                t.interrupt();
            }
        }
    }
}

class MyThreada implements Runnable {

    //终止线程也可用自定义标记
    public boolean flag = true;

    public MyThreada() {
        flag = true;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //检测线程是否中断
            if (Thread.interrupted()) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}
