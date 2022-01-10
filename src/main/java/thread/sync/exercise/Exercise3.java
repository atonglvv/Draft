package thread.sync.exercise;

/**
 * @program: draft
 * @description: synchronized exercise 1
 * t1 跟 t2 互斥, 但是执行顺序不确定
 * result:
 * c 一秒后 a b
 * c b 一秒后 a
 * b c 一秒后 a
 * @author: atong
 * @create: 2022-01-10 21:28
 */
public class Exercise3 {

    public static void main(String[ ] args) {
        Number3 n1 = new Number3();
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
        new Thread(() -> {
            System.out.println("begin");
            n1.c();
        }, "t3").start();
    }
}

class Number3 {
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("a");
    }

    public synchronized void b() {
        System.out.println("b");
    }

    public void c() {
        System.out.println("c");
    }
}