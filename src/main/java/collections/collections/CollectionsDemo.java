package collections.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: draft
 * @description: Collections
 * @author: atong
 * @create: 2021-05-08 20:59
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(7);

        System.out.println(list);

        //使用Collections排序
        Collections.sort(list);
        System.out.println(list);

        //使用二分查找, 前提从小到大排序
        int index = Collections.binarySearch(list, 3);
        System.out.println(index);

        //使用Collections随机排序
        Collections.shuffle(list);
        System.out.println(list);

        //使用Collections倒序排序
        Collections.reverse(list);
        System.out.println(list);

        //用特定的数据填充整个容器
        Collections.fill(list, 200);
        System.out.println(list);
    }
}
