package thread;

/**
 * @program: draft
 * @description: 公共类
 * @author: atong
 * @create: 2021-12-18 18:44
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
