package collections.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: ArrayList Remove Duplicates
 * ArrayList 去重的几种方式
 * @author: atong
 * @create: 2021-01-28 17:11
 */
public class ArrayListRemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        //LinkedHashSet去重
        ArrayList<?> withoutDuplicates = removeDuplicates(list);
        System.out.println(withoutDuplicates);
        //Stream 去重
        List<?> withoutDuplicatesForStream = removeDuplicatesForStream(list);
        System.out.println(withoutDuplicatesForStream);
        //HashSet 去重
        List<?> withoutDuplicatesForHashset = removeDuplicatesForHashset(list);
        System.out.println(withoutDuplicatesForHashset);
        //List contains 去重
        List<?> withoutDuplicatesForListContains = removeDuplicatesForListContains(list);
        System.out.println(withoutDuplicatesForListContains);

        System.out.println(list);

        //双重for循环去重
        List<?> withoutDuplicatesDoubleFor = removeDuplicatesDoubleFor(list);
        System.out.println(withoutDuplicatesDoubleFor);

        System.out.println(list);

    }

    /**
     * @description
     * 使用LinkedHashSet删除arraylist中的重复数据
     * LinkedHashSet是在一个ArrayList删除重复数据的最佳方法。LinkedHashSet在内部完成两件事：
     * - 删除重复数据
     * - 保持添加到其中的数据的顺序
     * @param list:
     * @return java.util.ArrayList<?>
     * @author atong
     * @date 2021/1/28 17:16
     * @version 1.0.0.1
     */
    public static ArrayList<?> removeDuplicates(ArrayList<?> list) {

        LinkedHashSet<?> hashSet = new LinkedHashSet<>(list);

        return new ArrayList<>(hashSet);
    }

    /**
     * @description
     * 使用steam的distinct()方法返回一个由不同数据组成的流，通过对象的equals（）方法进行比较。
     * 收集所有区域数据List使用Collectors.toList()。
     * Java程序，用于在不使用Set的情况下从java中的arraylist中删除重复项。
     * @param list:
     * @return java.util.List<?>
     * @author atong
     * @date 2021/1/28 17:25
     * @version 1.0.0.1
     */
    public static List<?> removeDuplicatesForStream(ArrayList<?> list) {

        List<?> withoutDuplicates = list.stream().distinct().collect(Collectors.toList());

        return withoutDuplicates;
    }

    /**
     * @description
     * 利用HashSet不能添加重复数据的特性
     * 由于HashSet不能保证添加顺序,所以只能作为判断条件保证顺序
     * @param list:
     * @return java.util.List<E>
     * @author atong
     * @date 2021/1/28 17:54
     * @version 1.0.0.1
     */
    public static <E>List<E> removeDuplicatesForHashset(ArrayList<E> list) {

        HashSet<E> set = new HashSet<>(list.size());
        List<E> withoutDuplicates = new ArrayList<>(list.size());

        for (E obj : list) {
            if (set.add(obj)) {
                withoutDuplicates.add(obj);
            }
        }
        return withoutDuplicates;
    }


    /**
     * @description
     * 利用List的contains方法循环遍历
     * 重新排序
     * 只添加一次数据,避免重复
     * @param list:
     * @return java.util.List<E>
     * @author atong
     * @date 2021/1/28 21:07
     * @version 1.0.0.1
     */
    public static <E>List<E> removeDuplicatesForListContains(ArrayList<E> list) {

        List<E> withoutDuplicates = new ArrayList<>(list.size());
        for (E obj : list) {
            if (!withoutDuplicates.contains(obj)) {
                withoutDuplicates.add(obj);
            }
        }
        return withoutDuplicates;
    }

    /**
     * @description
     * 双重for循环去重
     * @param list:
     * @return java.util.List<E>
     * @author atong
     * @date 2021/1/28 21:14
     * @version 1.0.0.1
     */
    public static <E>List<E> removeDuplicatesDoubleFor(ArrayList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i) == list.get(j)) {
                    list.remove(list.get(j));
                }
            }
        }
        return list;
    }

}
