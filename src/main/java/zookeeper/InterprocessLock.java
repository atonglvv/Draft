package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @program: draft
 * @description: zookeeper实现分布式排他锁
 * 利用 zookeeper 的同级节点的唯一性特性，在需要获取排他锁时，所有的客户端试图通过调用 create() 接口，
 * 在 /exclusive_lock 节点下创建临时子节点 /exclusive_lock/lock，最终只有一个客户端能创建成功，那么此客户端就获得了分布式锁。
 * 同时，所有没有获取到锁的客户端可以在 /exclusive_lock 节点上注册一个子节点变更的 watcher 监听事件，以便重新争取获得锁。
 * @author: atong
 * @create: 2022-06-04 18:44
 */
public class InterprocessLock {

    public static void main(String[] args)  {
        CuratorFramework zkClient = getZkClient();
        String lockPath = "/lock";
        InterProcessMutex lock = new InterProcessMutex(zkClient, lockPath);
        //模拟50个线程抢锁
        for (int i = 0; i < 50; i++) {
            new Thread(new TestThread(i, lock)).start();
        }
    }


    static class TestThread implements Runnable {
        private final Integer threadFlag;
        private final InterProcessMutex lock;

        public TestThread(Integer threadFlag, InterProcessMutex lock) {
            this.threadFlag = threadFlag;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.acquire();
                System.out.println("第" + threadFlag + "线程获取到了锁");
                //等到1秒后释放锁
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static CuratorFramework getZkClient() {
        String zkServerAddress = "127.0.0.1:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3, 5000);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString(zkServerAddress)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();
        return zkClient;
    }
}
