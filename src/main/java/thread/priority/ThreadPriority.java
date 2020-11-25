package thread.priority;

public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);
        Thread thread6 = new Thread(myPriority);
        Thread thread7 = new Thread(myPriority);
        Thread thread8 = new Thread(myPriority);

        thread2.setPriority(2);

        thread3.setPriority(3);

        thread4.setPriority(4);

        //设置普通优先级
        thread5.setPriority(Thread.NORM_PRIORITY);

        thread6.setPriority(6);

        //设置最小优先级
        thread7.setPriority(Thread.MIN_PRIORITY);

        //设置最大优先级
        thread8.setPriority(Thread.MAX_PRIORITY);

        //t1不设置优先级
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();


    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
