package datetime;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @program: Draft
 * @description: 比较 LocalDateTime 大小
 * @author: atong
 * @create: 2022-06-20 17:36
 */
public class CompareToDemo {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        TimeUnit.SECONDS.sleep(3);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        int i = now1.compareTo(now2);
        System.out.println(i);
    }
}
