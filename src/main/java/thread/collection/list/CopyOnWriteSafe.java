package thread.collection.list;

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: draft
 * @description: CopyOnWriteArrayList线程安全的
 * 写时复制
 * @author: atong
 * @create: 2021-12-19 22:20
 */
public class CopyOnWriteSafe {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                //添加元素
                list.add(UUID.randomUUID().toString().substring(0, 8));
                //读取元素
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
