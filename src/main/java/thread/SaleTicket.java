package thread;

/**
 * @program: draft
 * @description: 通过买票逻辑，看懂 synchronized
 * @author: atong
 * @create: 2021-12-18 18:55
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //创建四个线程 卖票
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread A").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread B").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread C").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread D").start();
    }
}

class Ticket {
    //票数
    private Integer num = 30;
    /* 此处可以将 synchronized 关键字 去掉, 执行代码 试一下 , 会出现 一下卖出多张票的问题*/
    public synchronized void sale () {
        //判断是否有票
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "︰卖出:" + (num--) + "剩下:" + num);
        }
    }
}
