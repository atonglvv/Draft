package thread.create;

/**
 * @program: draft
 * @description: 通过实现Runable接口创建线程
 * @author: atong
 * @create: 2021-12-18 14:55
 */
public class Implements {
    public static void main(String[] args) {
        Runnable runnable = new RunableTask();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    public static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }
}
