package exercises.e02;

import java.util.HashMap;

/**
 * @program: draft
 * @description: 统计单词次数
 * @author: atong
 * @create: 2020-12-01 13:58
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        String data = getData();
        //切割字符串,分离为word
        String[] words = data.split("\\s+");
        for (String word : words) {
            //从map中取count, 如果没有默认0
            Integer count = hm.getOrDefault(word, 0);
            hm.put(word, ++count);
        }
        //左对齐输出
        hm.forEach((k,v) -> System.out.format("%-10s  %d \n", k, v));
    }

    public static String getData() {
        return  "java  linux  mysql  java hadoop   java\n" +
                "linux  hadoop  spark  spark  java  hadoop\n" +
                "mysql  hadoop java  linux  spark\n" +
                "beijing  beijing  hangzhou   hangzhou   shenzhen\n" +
                "shenzhen   shenzhen   hangzhou   linux   java\n" +
                "spark  hadoop   collection  list  collection\n" +
                "map  set  map set   list  collection   spark";
    }
}
