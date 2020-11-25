package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: list并集/交集/差集
 * @author: atong
 * @create: 2020-11-25 20:08
 */
public class Operate {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("i");
        stringList.add("j");
        stringList.add("a");

        //一、求交集
        //方法1：直接通过retainAll直接过滤
        List<String> stringList1 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        stringList1.retainAll(stringList);
        System.out.println("交集1: " + stringList1);

        //方法2：通过过滤掉存在于stringList的数据
        List<String> stringList2 = new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        List<String> strings = stringList2.stream()
                .filter(stringList::contains)
                .collect(Collectors.toList());
        System.out.println("交集2：" + strings);

        //二、并集
        //有重并集
        List<String> stringList3 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        stringList3.addAll(stringList);
        System.out.println("并集: " + stringList3);

        //无重并集
        List<String> stringList4 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        List<String> stringList5 =  new ArrayList<>(Arrays.asList("a,b,c,i,j,a".split(",")));
        stringList4.removeAll(stringList5);
        stringList5.addAll(stringList4);

        System.out.println("无重并集: " + stringList5);

        //三、求差集
        //方法1：直接使用removeAll()方法
        List<String> stringList6 =  new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        stringList6.removeAll(stringList);
        System.out.println("差集1: " + stringList6);

        //方法2：通过过滤掉不存在于stringList的数据，然后和本数组进行交集处理
        List<String> stringList7 = new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        stringList7.retainAll(stringList6.stream()
                .filter(item -> !stringList.contains(item))
                .collect(Collectors.toList()));
        System.out.println("差集2：" + stringList7);
    }
}
