package thread.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: draft
 * @description: ConcurrentHashMap 是线程安全的
 * @author: atong
 * @create: 2021-12-21 22:50
 */
public class ConcurrentHashMapThreadSafe {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                /*
                 * 多线程 添加 读取 会报一下异常
                 * java.util.ConcurrentModificationException
                 */
                //添加元素
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                //读取元素
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
