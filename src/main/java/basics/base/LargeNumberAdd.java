package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/12 21:19
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class LargeNumberAdd {
    public static void main(String[] args) {
        String str = add("1357000", "246");
        System.out.println(str);
    }

    private static String add(String s1, String s2) {
        StringBuffer result = new StringBuffer();
        // 1.反转字符串
        s1 = new StringBuffer(s1).reverse().toString();
        s2 = new StringBuffer(s2).reverse().toString();

        // 获得长度
        int len1 = s1.length();
        int len2 = s2.length();

        int maxlen = len1 > len2 ? len1 : len2;

        // 是否越界
        boolean overFlow = false;
        int nOver = 0; // 溢出数量
        // 将短的字符串补成和长字符串一样的长度
        if (len1 < len2) {
            for (int x = len1; x < len2; x++) {
                s1 += "0";
            }
        } else if (len1 > len2) {
            for (int x = len2; x < len1; x++) {
                s2 += "0";
            }

        }

        // 3.将两个正整数相加，一位一位的加并加上进位

        for (int x = 0; x < maxlen; x++) {

            // 取出一位，相加 ，大于10则进一
            char c1 = s1.charAt(x);
            char c2 = s2.charAt(x);
            String sc1 = c1 + "";
            String sc2 = c2 + "";

            int nSum = Integer.parseInt(sc1) + Integer.parseInt(sc2);

            if ((nSum + nOver) >= 10) {
                // 如果是边界 ，则整体加一
                if (x == maxlen - 1) {
                    overFlow = true;
                }
                result.append(nSum - 10 + nOver);
                nOver = 1;
            } else {
                result.append(nSum + nOver);
                nOver = 0;

            }
        }
        if (overFlow) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}
