package thread.create;

/*
 *继承Thread类实现
 */
public class ThreadCreate extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(this.getName() + "======" + i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        ThreadCreate threadCreate = new ThreadCreate();

        /*调用start方法开启线程
         *线程开启不一定立即执行，由CPU调度执行
         * 调用start方法，就会产生一个新的线程，且该线程处于就绪状态
         */
        threadCreate.start();
        //调用run方法，不会产生新的线程，依旧在main线程中执行
        threadCreate.run();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main======" + i);
        }
    }
}
