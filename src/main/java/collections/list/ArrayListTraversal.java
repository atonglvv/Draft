package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: draft
 * @description: ArrayList遍历的三种方式
 * @author: atong
 * @create: 2020-12-28 15:43
 */
public class ArrayListTraversal {
    public void arrayListTraversal(List<Integer> lists){
        //第一种遍历方式
        System.out.print("for循环的遍历方式：");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i));
        }
        System.out.println();

        //第二种遍历方式
        System.out.print("foreach的遍历方式：");
        for (Integer list : lists) {
            System.out.print(list);
        }
        System.out.println();

        //第三种遍历方式
        System.out.print("Iterator的遍历方式：");
        for (Iterator<Integer> list = lists.iterator(); list.hasNext();) {
            System.out.print(list.next());
        }
    }

    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<Integer>();
        //添加元素
        for (int i = 0; i < 10; i++) {
            lists.add(i);
        }
        new ArrayListTraversal().arrayListTraversal(lists);
    }
}
