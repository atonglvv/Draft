package redis.maxmemorypolicy.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @program: draft
 * @description: redis 内存淘汰策略 LFU
 * @author: atong
 * @create: 2021-01-25 11:37
 */
public class LfuCache<K,V> {
    /** 缓存数据 */
    private HashMap<K, V> cache;
    /** 记录key的访问次数 */
    private HashMap<K, Integer> keyCount;
    /** 记录最少访问频率下的所有key */
    private HashMap<Integer, LinkedHashSet<K>> minkeys;

    /** 最小访问频率 */
    private int minFrequency;
    /** cache 容量 */
    private int capacity;

    public LfuCache(int capacity) {
        cache = new HashMap<>();
        keyCount = new HashMap<>();
        minkeys = new HashMap<>();
        this.capacity = capacity;
        this.minFrequency = 0;
    }

    public V get(K key) {
        V v = cache.get(key);
        if (v == null) {
            return null;
        }
        //增加key的频率
        increaseFrey(key);
        return v;
    }

    public void put(K key, V value) {
        // get方法里面会增加频次
        if (get(key) != null) {
            // 重新设置值
            cache.put(key, value);
            return;
        }

        // 超出容量，删除频率最低的key
        if (cache.size() >= capacity) {
            removeMinFreqKey();
        }

        cache.put(key, value);
        keyCount.put(key, 1);
        // key对应的value存在，返回存在的key
        // key对应的value不存在，添加key和value
        minkeys.putIfAbsent(1, new LinkedHashSet<>());
        minkeys.get(1).add(key);
        this.minFrequency = 1;
    }

    /**
     * @description 删除出现频率最低的key
     * @return void
     * @author atong
     * @date 2021/1/25 14:02
     * @version 1.0.0.1
     */
    private void removeMinFreqKey() {
        LinkedHashSet<K> keyList = minkeys.get(minFrequency);
        K deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            // 这里删除元素后不需要重新设置minFrequency
            // 因为put方法执行完会将minFrequency设置为1
            minkeys.remove(keyList);
        }
        cache.remove(deleteKey);
        keyCount.remove(deleteKey);
    }

    /**
     * @description 增加key的访问频率并更新最少访问频率下keySet
     * @param key: key
     * @return void
     * @author atong
     * @date 2021/1/25 13:48
     * @version 1.0.0.1
     */
    private void increaseFrey(K key) {
        int freq = keyCount.get(key);
        keyCount.put(key, freq + 1);
        minkeys.get(freq).remove(key);
        minkeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        minkeys.get(freq + 1).add(key);
        if (minkeys.get(freq).isEmpty()) {
            minkeys.remove(freq);
            // 最小频率的set为空，key被移动到minFreq+1对应的set了
            // 所以minFreq也要加1
            if (freq == this.minFrequency) {
                this.minFrequency++;
            }
        }
    }

    @Override
    public final String toString() { return cache.toString(); }
}
