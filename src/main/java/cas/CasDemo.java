package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: draft
 * @description: CAS
 * @author: atong
 * @create: 2020-12-30 19:38
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        ai.compareAndSet(1, 5);
        System.out.println(ai);
    }
}
