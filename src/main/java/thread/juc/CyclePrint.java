package thread.juc;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-04-14 10:34
 */
public class CyclePrint implements Runnable {

    private static int totalNumber = 100;

    private static AtomicInteger value = new AtomicInteger(0);

    private static int inputNum = 0;

    private static CountDownLatch countDownLatch;

    public static void main(String[] args) {
        //输入线程数量
        Scanner in = new Scanner(System.in);
        int threadNum = in.nextInt();
        inputNum = threadNum;
        countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new CyclePrint(), "thread" + i).start();
            countDownLatch.countDown();
        }
    }


    @Override
    public void run() {
        try {
            countDownLatch.await();
            //System.out.println("begin value is " + value.get());
            while (value.get() < totalNumber) {
                synchronized (value) {
                    String name = Thread.currentThread().getName();
                    int taskThreadNum = Integer.parseInt(name.substring(6, 7));
                    if (value.get() == taskThreadNum || value.get() % inputNum == taskThreadNum) {
                        System.out.println(name + " value is" + value);
                        value.getAndIncrement();
                        value.notifyAll();
                    } else {
                        value.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
