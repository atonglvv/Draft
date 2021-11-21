package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: draft
 * @description: list 转 Array
 * @author: atong
 * @create: 2021-11-16 11:40
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] strings = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
