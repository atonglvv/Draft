package stream.get;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @program: draft
 * @description: 获取Stream的方式
 *  1.Collection中 方法
 *      Stream stream()
 *  2.Stream接口 中静态方法
 *      of(T...t) 向Stream中添加多个数据
 * @author: atong
 * @create: 2020-11-19 14:32
 */
public class GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("stream1");
        list.add("stream2");
        list.add("stream3");
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        set.add("stream1");
        set.add("stream2");
        set.add("stream3");
        Stream<String> stream2 = set.stream();

        String[] array = {"array1", "array2", "array3"};
        Stream<String> stream3 = Stream.of(array);
        stream3.forEach(System.out::println);


    }
}
