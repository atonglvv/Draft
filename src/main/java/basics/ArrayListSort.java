package basics;

import tool.Student;
import tool.StudentWithCompara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: carver
 * @Date: 2019/1/21 12:45
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class ArrayListSort {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student("Carver",18));
        list.add(new Student("mwwfe",20));
        list.add(new Student("ahh",22));
        list.add(new Student("AHH",16));

        /**
         * 通过sort方法的第二个参数传入一个Comparator接口对象
         * 相当于是传入一个比较对象大小的算法到sort 方法中
         * 由于Java中没有函数指针、仿函数、委托这样的概念
         * 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
         */
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //比较学生姓名
                return o1.getName().compareTo(o2.getName());
            }
        });


        list.forEach(x -> System.out.println(x));


    }
}
