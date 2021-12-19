package thread.communicate;

/**
 * @program: draft
 * @description: Wati与Notify实现线程间通信
 * @author: atong
 * @create: 2021-12-19 18:14
 */
public class WatiAndNotify2 {
    public static void main(String[] args) {
        Share2 share = new Share2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.desc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.desc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread D").start();
    }
}

//资源类
class Share2 {
    //初始值
    private Integer number = 0;

    //+1的方法
    public synchronized void incr () throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }

    //-1的方法
    public synchronized void desc () throws InterruptedException {
        while (number != 1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }
}
