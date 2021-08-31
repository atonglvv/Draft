package bigDecimal;

import java.math.BigDecimal;

/**
 * @program: draft
 * @description: bigDecimal相关操作
 * @author: atong
 * @create: 2021-01-07 10:16
 */
public class CompareTo {
    public static void main(String[] args) {
        BigDecimal bigDecimal0 = new BigDecimal("0");
        BigDecimal bigDecimalf1 = new BigDecimal("-1");
        //判断是否等于0
        if (bigDecimal0.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("bigDecimal0 equals 0");
        }
        if (bigDecimalf1.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("bigDecimalf1 小于等于 0");
        }



        BigDecimal bigDecimal100 = new BigDecimal("100");
        BigDecimal bigDecimal88 = new BigDecimal("88");
        BigDecimal bigDecimal120 = new BigDecimal("120");
        //判断是否小于100
        if (bigDecimal88.compareTo(bigDecimal100) < 0) {
            System.out.println("bigDecimal88 小于 bigDecimal100");
        }
        //判断是否大于100
        if (bigDecimal120.compareTo(bigDecimal100) > 0) {
            System.out.println("bigDecimal120 大于 bigDecimal100");
        }
    }
}
