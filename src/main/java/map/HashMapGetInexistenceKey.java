package map;

import java.util.HashMap;

/**
 * @program: draft
 * @description: HashMap获取不存在的key
 * @author: atong
 * @create: 2021-01-19 09:26
 */
public class HashMapGetInexistenceKey {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("a", "1");
        hm.put("b", "2");
        String c = hm.get("c");
        System.out.println("HashMap 获取一个不存在的key的结果是: " + c);
    }
}
