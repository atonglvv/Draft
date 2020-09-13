package thread;

/**
 * @Auther: carver
 * @Date: 2019/1/23 12:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 同步方法和非同步方法是否可以同时调用? Y
 */
public class SynAndNoSyn {

    public void m1() {

        System.out.println(Thread.currentThread().getName() + "m1 Start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 End");

    }

    public void m2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2");
    }


    public static void main(String[] args) {
        SynAndNoSyn t = new SynAndNoSyn();

//        new Thread(() -> t.m1(),"t1").start();
//        new Thread(() -> t.m2(),"t2").start();

        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t.m1();
//            }
//        });


    }
}
