package thread.sync.exercise;

/**
 * @program: draft
 * @description: synchronized exercise 1
 * t1 跟 t2 锁的对象都是Class对象, 尽管t1调用的n1对象的方法,t2调用的n2的方法,  但是 t1 跟 t2 还是互斥的
 * result:
 * b 一秒后 a
 * 一秒后 a b
 * @author: atong
 * @create: 2022-01-10 21:28
 */
public class Exercise6 {

    public static void main(String[ ] args) {
        Number6 n1 = new Number6();
        Number6 n2 = new Number6();
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

class Number6 {
    public static synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("a");
    }

    public static synchronized void b() {
        System.out.println("b");
    }
}