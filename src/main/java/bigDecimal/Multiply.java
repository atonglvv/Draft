package bigDecimal;

import java.math.BigDecimal;

/**
 * @program: draft
 * @description: multiply
 * @author: atong
 * @create: 2021-08-30 18:22
 */
public class Multiply {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.2);
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(100));
        System.out.println(multiply);
        int i = multiply.intValue();
        System.out.println(i);
    }
}
