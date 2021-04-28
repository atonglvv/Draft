package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-28 22:33
 */
public class ParseMap {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> gf = new HashMap<>();
        gf.put("name", "balabala");
        gf.put("age", 18);
        map.put("name", "atong");
        map.put("age", 19);
        map.put("fg", gf);

        String mapStr = JSON.toJSONString(map);
        System.out.println(mapStr);

        Map<String,Object> parse = JSON.parseObject(mapStr, new TypeReference<Map<String,Object>>(){});
        System.out.println(parse.toString());

        String s = JSON.toJSONString(parse);
        System.out.println(s);
    }
}
