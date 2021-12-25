package thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: draft
 * @description: ReadWriteLock 实现一个本地Map缓存（线程安全的）
 * @author: atong
 * @create: 2021-12-25 15:11
 */
public class ReadWriteLockDemo {

    private static Map<String, Object> cache = new HashMap<>();

    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static Object get(String key) {
        rwl.readLock().lock();
        try {
            return cache. get( key);
        } finally {
            rwl.readLock().unlock();
        }
    }

    public static Object put(String key, Object value) {
        rwl.writeLock().lock();
        try {
            return cache.put(key, value) ;
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public static void clear() {
        rwl.writeLock().lock();
        try {
            cache.clear( );
        } finally {
            rwl.writeLock().unlock();
        }
    }
}

