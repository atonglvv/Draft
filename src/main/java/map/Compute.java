package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description: map.ComputeIfAbsent
 * @author: atong
 * @create: 2021-08-30 16:58
 */
public class Compute {
    public static void main(String[] args) {
        //compute1 对 hashMap 中指定 key 的 Value 进行重新计算
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "111");
        map.put(2L, "222");
        map.put(3L, "333");
        map.compute(1L, (k, v) -> k + "a");
        System.out.println(map);
        //compute2 对 hashMap 中指定 key 的 Value 进行重新计算
        Map<Long, String> map1 = new HashMap<>();
        map1.put(1L, "111");
        map1.put(2L, "222");
        map1.put(3L, "333");
        map1.compute(1L, (k, v) -> v + "a");
        map1.compute(4L, (k, v) -> v + "a");
        System.out.println(map1);

        //computeIfAbsent 对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中
        Map<Long, String> map2 = new HashMap<>();
        map2.put(1L, "111");
        map2.put(2L, "222");
        map2.put(3L, "333");
        map2.computeIfAbsent(3L, k -> "a");
        map2.computeIfAbsent(4L, k -> "a");
        System.out.println(map2);


        //computeIfPresent 对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。
        Map<Long, String> map3 = new HashMap<>();
        map3.put(1L, "111");
        map3.put(2L, "222");
        map3.put(3L, "333");
        map3.computeIfPresent(3L, (k, v) -> v + "a");
        map3.computeIfPresent(4L, (k, v) -> v + "a");
        System.out.println(map3);
    }
}
