package thread.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: draft
 * @description: 证明ArrayList线程不安全
 * @author: atong
 * @create: 2021-12-19 21:42
 */
public class ArrayListThreadSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                /*
                 * 多线程 添加 读取 会报一下异常
                 * java.util.ConcurrentModificationException
                 */
                //添加元素
                list.add(UUID.randomUUID().toString().substring(0, 8));
                //读取元素
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
