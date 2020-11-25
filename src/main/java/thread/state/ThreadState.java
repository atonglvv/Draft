package thread.state;


/**
 * 观测线程的状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("............");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);  //NEW

        //线程启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);  //RUNNABLE

        //只要线程不终止就一直输出状态
        while(state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();  //获取线程状态
            System.out.println(state);  //输出状态
        }

        //线程只能执行一次，一旦进入死亡状态，就不能再次启动。
        //所以下面这句会报错。
        //thread.start();

    }
}
