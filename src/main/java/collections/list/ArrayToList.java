package collections.list;

import java.util.Arrays;
import java.util.List;

/**
 * @program: draft
 * @description: Array To List
 * @author: atong
 * @create: 2021-11-16 11:41
 */
public class ArrayToList {
    public static void main(String[] args) {
        String[] arrays = {"a", "b", "c"};
        List<String> list = Arrays.asList(arrays);
        System.out.println(list.toString());
    }
}
