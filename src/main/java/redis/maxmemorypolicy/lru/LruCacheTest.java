package redis.maxmemorypolicy.lru;

import java.util.Collections;
import java.util.Map;

/**
 * @program: draft
 * @description: redis LRU内存淘汰策略测试
 * @author: atong
 * @create: 2021-01-25 10:46
 */
public class LruCacheTest {
    public static void main(String[] args) {
        LruCache<String,String> lruCache = new LruCache<>(3);
        Map<String, String> safeCache = Collections.synchronizedMap(lruCache);
        safeCache.put("1","a");
        safeCache.put("2","b");
        safeCache.get("1");
        safeCache.put("3","c");
        safeCache.put("4","d");
        System.out.println(safeCache.toString());
    }
}
