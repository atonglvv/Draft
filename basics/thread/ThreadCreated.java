package basics.thread;

/**
 * @Auther: carver
 * @Date: 2019/1/21 19:09
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ThreadCreated {

    public static void main(String[] args) {

        ThreadExtends t1 = new ThreadExtends();
        t1.start();

        ThreadImp timp = new ThreadImp();
        Thread t2 = new Thread(timp);
        t2.start();

    }
}

class ThreadExtends extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName() + "-" + i);
        }
    }
}


class ThreadImp implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
//            System.out.println(i);
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}