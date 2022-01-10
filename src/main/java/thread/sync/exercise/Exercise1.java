package thread.sync.exercise;

/**
 * @program: draft
 * @description: synchronized exercise 1
 * t1 跟 t2 互斥, 但是执行顺序不确定
 * @author: atong
 * @create: 2022-01-10 21:28
 */
public class Exercise1 {

    public static void main(String[ ] args) {
        Number n1 = new Number();
        new Thread(() ->{
            System.out.println("begin");
            n1.a();
        }, "t1").start();
        new Thread(() -> {
            System.out.println("begin");
            n1.b();
        }, "t2").start();
    }
}

class Number {
    public synchronized void a() {
        System.out.println("a");
    }

    public synchronized void b() {
        System.out.println("b");
    }
}