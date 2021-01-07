package bigDecimal;

import java.math.BigDecimal;

/**
 * @program: draft
 * @description: bigDecimal相关操作
 * @author: atong
 * @create: 2021-01-07 10:16
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0");
        //判断是否等于0
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("bigDecimal equals 0");
        }
    }
}
