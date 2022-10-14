package bigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: Demo
 * @author: atong
 * @create: 2022-10-11 15:35
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        bigDecimals.add(new BigDecimal("2.1"));
        bigDecimals.add(new BigDecimal("2.2"));
        bigDecimals.add(new BigDecimal("2.3"));
        bigDecimals.add(new BigDecimal("2.5"));
        bigDecimals.add(null);
        bigDecimals.add(null);
        // 排序
        List<BigDecimal> collect = bigDecimals.stream().sorted().collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
