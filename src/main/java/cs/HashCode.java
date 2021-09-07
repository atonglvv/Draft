package cs;

/**
 * @program: draft
 * @description: Hash相关Class
 * @author: atong
 * @create: 2021-09-07 10:31
 */
public class HashCode {

    public static void main(String[] args) {
        String hello = "hello";

        /*
         * 进入查看源码:
         * 为什么使用 31 作为乘数?
         * 1. 31是个奇质数, 如果选择偶数会导致乘积运算时数据溢出,
         *    一般在设计哈希算法时，会选择一个特殊的质数, 31是一个不大不小的质数，是优选乘子;
         * 2. 2^5=32. so -> 31 * i == (i << 5)-i。 31 * i可以被JVM优化为(i << 5) - i, 使用位运算提升性能;
         * 3. 据统计十万个单词 计算hash, 乘数31 hahs碰撞率较低.
         *
         */
        hello.hashCode();
    }

}
