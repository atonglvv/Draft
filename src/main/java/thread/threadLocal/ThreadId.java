package thread.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Draft
 * @description: ThreadLocal 源码注释Demo
 * @author: atong
 * @create: 2022-06-27 16:22
 */
public class ThreadId {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static void remove() {
        threadId.remove();
    }

    public static void incrementSameThreadId() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "_" + i + ", threadId: " + ThreadId.get());
            }
        } finally {
            ThreadId.remove();
        }
    }

    public static void main(String[] args) {
        incrementSameThreadId();
        new Thread(ThreadId::incrementSameThreadId).start();
        new Thread(ThreadId::incrementSameThreadId).start();
    }
}