package basics;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/2/21 13:18
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Sm {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(8);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(6);
        list3.add(25);
        list3.add(56);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(9);
        list4.add(16);
        list4.add(25);
        list4.add(37);


        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println("123");

        System.out.println(mergeNSort(lists).toString());
    }

    public static ArrayList<Integer> mergeNSort(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> result = lists.get(0);

        for (int i = 1; i < lists.size(); i++) {
            result.addAll(lists.get(i));
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return result;

    }


}
