package collections.list;

import java.util.ArrayList;

/**
 * @program: draft
 * @description: ArrayList add方法
 * @author: atong
 * @create: 2021-01-18 16:15
 */
public class ArrayListAdd {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        /**
         * 如果不传index则元素插入到数组末尾。
         * 如果传index参数,则之前位于index位置以及其后元素往后移一位。新的element插入到index位置。
         * @param index（可选参数）- 表示元素所插入处的索引值
         * @param element - 要插入的元素
         */
        arrayList.add(0, 0);
        System.out.println(arrayList.toString());
    }
}
