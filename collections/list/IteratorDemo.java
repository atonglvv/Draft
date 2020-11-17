package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: draft
 * @description: Iterator基本使用
 * @author: atong
 * @create: 2020-11-16 20:34
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("2".equals(next)) {
                iterator.remove();
            }
        }
        //lambda removeIf 实现以上逻辑
        list.removeIf(next -> "2".equals(next));
        //lambda removeIf 简写 实现以上逻辑
        list.removeIf("2"::equals);

        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
