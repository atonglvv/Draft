package thread.stop;

public class ThreadStop implements Runnable{
    //设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag) {
            System.out.println("run......Thread" + i++);
        }
    }
    //设置一个公共方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        Thread thread = new Thread(threadStop);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("mian--" + i);
            if (i == 999) {
                //调用自己写的stop方法，切换flag，让线程停止
                threadStop.stop();
                System.out.println("线程该停止了...");
            }
        }

    }
}
