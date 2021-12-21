package thread.collection.set;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: draft
 * @description: CopyOnWriteArraySet 线程安全的
 * @author: atong
 * @create: 2021-12-21 22:33
 */
public class CopyOnWriteSafe {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                //添加元素
                set.add(UUID.randomUUID().toString().substring(0, 8));
                //读取元素
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
