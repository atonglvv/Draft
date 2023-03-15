package bigDecimal;

import java.math.BigDecimal;

/**
 * @program: Draft
 * @description: BigDecimal To String
 * @author: atong
 * @create: 2023-03-15 14:28
 */
public class BigDecimalToString {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("3.00");
        System.out.println(b);
        System.out.println(b.stripTrailingZeros().toPlainString());

        BigDecimal a = new BigDecimal("3.10");
        System.out.println(a);
        System.out.println(a.stripTrailingZeros().toPlainString());
    }
}
