package basics.base;

import java.util.HashSet;

/**
 * @Auther: carver
 * @Date: 2019/4/13 09:27
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Three {
    public static void main(String[] args) {
        new Three().fun("scott","create");
    }
    public void fun(String str1,String str2) {
        HashSet<Character> str1set = new HashSet<>();
        HashSet<Character> str2set = new HashSet<>();
        HashSet<Character> allset = new HashSet<>();
        HashSet<Character> temp = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            str1set.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            str2set.add(str2.charAt(i));
        }
        allset.addAll(str1set);
        allset.addAll(str2set);
        System.out.println("和数组：" + allset);
        //保存str1set
        temp.addAll(str1set);

        str2set.forEach(x -> {
            if (str1set.contains(x)) {
                str1set.remove(x);
            }
        });
        System.out.println("A - B:" + str1set);

        temp.forEach(x -> {
            if (str2set.contains(x)) {
                str2set.remove(x);
            }
        });
        System.out.println("B - A:" + str2set);
    }
}
