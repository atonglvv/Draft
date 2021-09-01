package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description: Merge
 * @author: atong
 * @create: 2021-09-01 16:03
 */
public class Merge {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.merge(1, 2, Integer::sum);
        System.out.println(map);
    }
}
