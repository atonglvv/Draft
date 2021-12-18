package thread.create;

/**
 * @program: draft
 * @description: 通过继承Thread类创建线程
 * @author: atong
 * @create: 2021-12-18 14:50
 */
public class Extends {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }
}
