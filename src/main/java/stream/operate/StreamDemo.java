package stream.operate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: draft
 * @description:
 * Stream相关operate
 *  forEach
 *  filter
 *  count
 *  limit
 *  skip
 *  concat
 * @author: atong
 * @create: 2020-11-19 15:24
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("stream1");
        list.add("stream2");
        list.add("stream3");

        /**
         * void forEach(Consumer<? super T> action);
         */
        list.forEach(x -> System.out.println(x));

        /**
         * Stream<T> filter(Predicate<? super T> predicate);
         */
        Stream<String> filterResult = list.stream().filter(x -> x.endsWith("1"));

        /**
         * long count();
         */
        System.out.println(filterResult.count());

        /**
         * Stream<T> limit(long maxSize);
         */
        list.stream().limit(2).forEach(System.out::println);

        /**
         * 跳过前几个元素
         * Stream<T> skip(long n);
         */
        list.stream().skip(2).forEach(System.out::println);

        /**
         * 流合并
         * public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
         */
        Stream<String> stream4 = Stream.of("stream4");
        Stream<String> stream5 = Stream.of("stream5");
        Stream<String> concat = Stream.concat(stream4, stream5);
        concat.forEach(System.out::println);

    }

}
