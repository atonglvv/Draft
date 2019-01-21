package jvm;

/**
 * testGC()方法执行后，objA和objB会不会GC呢？
 * @author Carver
 */
public class ReferenceCountingGC {

        public Object instance = null;

        private static final int _1MB = 1024*1024;

        /*
         * 这个成员的意义：占点内存，以便在GC日志中能看清是否被回收过
         */
        private byte[] bigSize = new byte[2 * _1MB];


        public static void testGC() {
            ReferenceCountingGC objA = new ReferenceCountingGC();
            ReferenceCountingGC objB = new ReferenceCountingGC();

            objA.instance = objB;
            objB.instance = objA;

            objA = null;
            objB = null;

            // objA和objB是否会被回收？
            System.gc();
        }

        /*
         * 参数：
         *  -verbose:gc         // 打印垃圾回收的日志信息，简单信息
         *  -XX:+PrintGCDetails  // 详细信息
         */
        public static void main(String[] args) {
            ReferenceCountingGC.testGC();
        }
}
