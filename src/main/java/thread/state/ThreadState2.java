package thread.state;

/**
 * @program: draft
 * @description: Java中线程的状态
 * @author: atong
 * @create: 2022-01-04 21:35
 */
public class ThreadState2 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run () {
                System.out.println("running");
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run () {
                while (true) {

                }
            }
        };
        t2.start();

        Thread t3 = new Thread("t3") {
            @Override
            public void run () {
                System.out.println("running");
            }
        };
        t3.start();

        Thread t4 = new Thread("t4") {
            @Override
            public void run() {
                synchronized (ThreadState2.class) {
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        t5.start();


        Thread t6 = new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadState2.class) {
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        System.out.println(" t1 state = " + t1.getState());
        System.out.println(" t2 state = " + t2.getState());
        System.out.println(" t3 state = " + t3.getState());
        System.out.println(" t4 state = " + t4.getState());
        System.out.println(" t5 state = " + t5.getState());
        System.out.println(" t6 state = " + t6.getState());
    }
}
