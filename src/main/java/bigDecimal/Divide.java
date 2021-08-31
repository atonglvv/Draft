package bigDecimal;

import java.math.BigDecimal;

/**
 * @program: draft
 * @description: divide
 * @author: atong
 * @create: 2021-08-31 17:05
 */
public class Divide {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(5);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(2));
        System.out.println(divide);
        /*
         * 参数 1：除数
         * 参数 2：精准度(保留几位小数)
         * 参数 3：取值方式
         */
        BigDecimal divide1 = bigDecimal.divide(new BigDecimal(3), 2, BigDecimal.ROUND_CEILING);
        System.out.println(divide1);
    }
}
