package thread;

/**
 * @Auther: carver
 * @Date: 2019/1/21 19:52
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
 *              程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
 *              所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
 */
public class ThreadJoin {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread);
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main - " + i);
            if (i == 20) {
                try {
                    //让t线程执行完毕
                    t.join();
                    /**
                     * join方法可以传递参数，join(10)表示main线程会等待t1线程10毫秒，10毫秒过去后，
                     * main线程和t1线程之间执行顺序由串行执行变为普通的并行执行
                     */
                    //t.join(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
