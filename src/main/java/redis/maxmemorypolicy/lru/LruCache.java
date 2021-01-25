package redis.maxmemorypolicy.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: draft
 * @description: redis 内存淘汰策略之Lru
 * @author: atong
 * @create: 2021-01-25 10:37
 */
public class LruCache<K,V> extends LinkedHashMap<K,V> {

    /** 缓存容量 */
    private int cacheSize;

    public LruCache (int cacheSize) {
        /**
         * initialCapacity: 初始容量大小
         * loadFactor: 负载因子
         * accessOrder: false基于插入排序（默认），true基于访问排序
         */
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 当调用put或者putAll方法时会调用如下方法, 是否删除最老的数据，默认为false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
