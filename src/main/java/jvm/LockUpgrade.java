package jvm;

import common.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * @program: draft
 * @description: 锁升级
 * @author: atong
 * @create: 2022-04-10 17:49
 */
public class LockUpgrade {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.println("无状态(001):" + ClassLayout.parseInstance(user).toPrintable());
        /*
         * Jvm 默认延时4s自动开启偏向锁, 可通过 -XX:BiasedLockingStartupDelay=0 取消延时;
         * 如果想要禁用偏向锁, 可通过 -XX:UseBiasedLocking = false来设置
         */
        Thread.sleep(4000);
        User user1 = new User();
        System.out.println("启用偏向锁(101):" + ClassLayout.parseInstance(user1).toPrintable());

        /*
         * 验证, 线程释放锁后(代码执行完后), 不会释放对象头MarkWord中的ThreadId
         */
        for (int i = 0; i < 2; i++) {
            synchronized (user1) {
                System.out.println("偏向锁(101)(带线程Id):" + ClassLayout.parseInstance(user1).toPrintable());
            }
            System.out.println("偏向锁释放(101)(带线程Id):" + ClassLayout.parseInstance(user1).toPrintable());
        }

        new Thread(() -> {
            synchronized (user1) {
                System.out.println("轻量级锁(00):" + ClassLayout.parseInstance(user1).toPrintable());
                try {
                    System.out.println("======睡眠3s======");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("轻量-->重量(10):" + ClassLayout.parseInstance(user1).toPrintable());
            }
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (user1) {
                System.out.println("重量级锁(10):" + ClassLayout.parseInstance(user1).toPrintable());
            }
        }).start();

    }
}
