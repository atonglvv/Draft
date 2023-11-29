package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description: HashMap下标越界
 * 笑死我了, HashMap 哪有下标 啊!!!
 * @author: atong
 * @create: 2022-03-21 16:01
 */
public class OutOfBounds {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        System.out.println(map.get(5));
    }
}
