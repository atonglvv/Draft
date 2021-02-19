package sword.leetcode.linearlist.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: draft
 * @description:
 * Gray Code
 * The gray code[格雷码] is a binary numeral[n.数字,adj.数字的;表示数字的] system
 * where two successive[adj.连续的;继承的;依次的;接替的] values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * • For a given n, a gray code sequence is not uniquely defined.
 * • For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * • For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 *
 * Solution:
 * gray code: 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码（Gray Code），
 * 另外由于最大数与最小数之间也仅一位数不同，即“首尾相连”，因此又称循环码或反射码。
 *
 * 自然二进制码转换为格雷码公式:  g0 = b0, gi = bi ⊕ bi-1
 * 保留自然二进制码的最高位作为格雷码的最高位，格雷码次高位为二进制码的高位与次高位异或，其余各位与次高位的求法类似。
 * 例如，将自然二进制码1001，转换为格雷码的过程是:保留最高位;然后将第1位的Ⅰ和第2位的0异或，得到1，作为格雷码的第2位;
 * 将第2位的0和第3位的0异或，得到0，作为格雷码的第3位;将第3位的0和第4位的1异或，得到1，作为格雷码的第4位，最终，格雷码为1101。
 *
 * 格雷码转换为自然二进制码公式:   b0 = g0, bi = bi ⊕ gi-1
 * 保留格雷码的最高位作为自然二进制码的最高位，次高位为自然二进制高位与格雷码次高位异或，其余各位与次高位的求法奕似。
 * 例如，将格雷码10000转换为自然二进制码的过程是：
 * 保留最高位1，作为自然二进制码的最高位;
 * 然后将自然二进制码的第1位1和格雷码的第2位0异或，得到1，作为自然二进制码的第2位;
 * 将自然二进制码的第2位1和格雷码的第3位0异或，得到1，作为自然二进制码的第3位;
 * 将自然二进制码的第3位1和格雷码的第4位0异或，得到1，作为自然二进制码的第4位，最终，自然二进制码为1111。
 *
 * 格雷码有数学公式：整数n的格雷码是 n ⊕ (n/2)。
 * 这题要求生成n比特的所有格雷码。
 * 方法1,最简单的方法，利用数学公式，对从0～2”-1的所有整数，转化为格雷码。
 * 方法2,n比特的格雷码，可以递归地从n-1比特的格雷码生成。如图GrayCode.png
 *
 * @author: atong
 * @create: 2021-02-18 10:08
 */
public class GrayCode {
    public static void main(String[] args) {
        List<Integer> list = grayCode(2);
        List<Integer> list1 = grayCodeI(2);
        System.out.println(list);
        System.out.println(list1);
    }


    /**
     * 公式法
     * @param n 代表编码总位数的非负整数 n
     * @return 格雷编码序列
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // 2^n
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            result.add(binaryToGray(i));
        }
        return result;
    }

    public static int binaryToGray (int n) {
        //n ⊕ (n/2)
        return n ^ (n >> 1);
    }


    /**
     * The first few steps of the reflect-and-prefix method.
     * @param n 代表编码总位数的非负整数 n
     * @return 格雷编码序列
     */
    public static List<Integer> grayCodeI(int n) {
        List<Integer> result = new ArrayList<Integer>() {{add(0);}};
        for (int i = 0; i < n; i++) {
            int highestBit = 1 << i;
            //要反着遍历,才能对称
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(highestBit | result.get(j));
            }
        }
        return result;
    }
}
