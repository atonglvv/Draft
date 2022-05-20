package collections.list;


import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-05-19 16:28
 */
public class ListUtilsDemo {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = ListUtils.union(list1, list2);
        System.out.println(union.toString());
    }
}
