package exercises.e03;

import java.util.HashMap;

/**
 * @program: draft
 * @description: 统计字符个数
 * @author: atong
 * @create: 2020-12-01 16:34
 */
public class Demo {
    public static void main(String[] args) {
        String data = getData();
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] chars = data.toCharArray();
        for (char c : chars) {
            Integer count = hm.getOrDefault(c, 0);
            hm.put(c, ++count);
        }
        hm.forEach((k,v) -> System.out.print(k + "(" + v + ")"));
    }

    public static String getData() {
        return  "abccaabdsswaabbsc";
    }
}
