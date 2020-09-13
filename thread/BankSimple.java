package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: carver
 * @Date: 2019/1/23 12:37
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 参见basics.thread.SynAndNoSyn，脏读问题
 */
public class BankSimple {

    String name;
    double balance;

    //写操作
    public synchronized void set(String name,double balance) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    //读操作 解决：加同步
    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        BankSimple a = new BankSimple();
        new Thread(() -> a.set("carver",1000.0d)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("carver"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("carver"));


    }

}
