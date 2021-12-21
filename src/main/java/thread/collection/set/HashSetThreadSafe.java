package thread.collection.set;

import java.util.*;

/**
 * @program: draft
 * @description: HashSet线程安全问题
 * 证明HashSet不安全
 * @author: atong
 * @create: 2021-12-21 22:29
 */
public class HashSetThreadSafe {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                /*
                 * 多线程 添加 读取 会报一下异常
                 * java.util.ConcurrentModificationException
                 */
                //添加元素
                set.add(UUID.randomUUID().toString().substring(0, 8));
                //读取元素
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
