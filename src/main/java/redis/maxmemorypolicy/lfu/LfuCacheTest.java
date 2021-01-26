package redis.maxmemorypolicy.lfu;

import redis.maxmemorypolicy.lru.LruCache;

import java.util.Collections;
import java.util.Map;

/**
 * @program: draft
 * @description: redis 内存淘汰策略LFU测试类
 * @author: atong
 * @create: 2021-01-25 17:12
 */
public class LfuCacheTest {
    public static void main(String[] args) {
        LfuCache<String,String> lfuCache = new LfuCache<>(3);
        lfuCache.put("1","a");
        lfuCache.put("2","b");
        lfuCache.get("1");
        lfuCache.get("1");
        lfuCache.get("2");
        lfuCache.put("3","c");
        lfuCache.put("4","d");
        System.out.println(lfuCache.toString());
    }
}
