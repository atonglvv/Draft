package thread.sync.exercise;

/**
 * @program: draft
 * @description: synchronized exercise 1
 * t1 跟 t2 锁的对象不同, 因为 a()是静态方法,锁的是class对象。所以 t1 跟 t2 不互斥
 * result:
 * b 一秒后 a
 * @author: atong
 * @create: 2022-01-10 21:28
 */
public class Exercise5 {

    public static void main(String[ ] args) {
        Number5 n1 = new Number5();
        new Thread(() ->{
            System.out.println("begin");
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            System.out.println("begin");
            n1.b();
        }, "t2").start();
    }
}

class Number5 {
    public static synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("a");
    }

    public synchronized void b() {
        System.out.println("b");
    }
}