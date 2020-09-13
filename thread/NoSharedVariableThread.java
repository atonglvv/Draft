package thread;

/**
 * @Auther: carver
 * @Date: 2019/1/21 16:34
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 多个线程之间不共享变量线程安全的情况
 */
public class NoSharedVariableThread extends Thread{

    private int count = 5;

    public NoSharedVariableThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + NoSharedVariableThread.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        NoSharedVariableThread a = new NoSharedVariableThread("A");
        NoSharedVariableThread b = new NoSharedVariableThread("B");
        NoSharedVariableThread c = new NoSharedVariableThread("C");

        a.start();
        b.start();
        c.start();
    }
}
