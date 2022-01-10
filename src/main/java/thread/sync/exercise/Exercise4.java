package thread.sync.exercise;

/**
 * @program: draft
 * @description: synchronized exercise 1
 * t1 跟 t2 锁的对象不同, 所以不互斥
 * result:
 * b 一秒后 a
 * @author: atong
 * @create: 2022-01-10 21:28
 */
public class Exercise4 {

    public static void main(String[ ] args) {
        Number4 n1 = new Number4();
        Number4 n2 = new Number4();
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
            n2.b();
        }, "t2").start();
    }
}

class Number4 {
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("a");
    }

    public synchronized void b() {
        System.out.println("b");
    }
}