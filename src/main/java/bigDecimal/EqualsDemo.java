package bigDecimal;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2023-02-21 14:22
 */
public class EqualsDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimala = new BigDecimal("2.10");
        BigDecimal bigDecimalb = new BigDecimal("2.1");
        // 两者不相等
        System.out.println(ObjectUtils.notEqual(bigDecimala, bigDecimalb));
        System.out.println(ObjectUtil.notEqual(bigDecimala, bigDecimalb));
        System.out.println(ObjectUtil.equals(bigDecimala, bigDecimalb));
    }
}
