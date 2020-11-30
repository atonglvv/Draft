package exercises.e01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: 题目 ../e01.md
 * @author: atong
 * @create: 2020-11-30 16:19
 */
public class Demo {
    public static void main(String[] args) {
        //1. 读取这些数据， 每一行的数据封装到一个Student对象中， 存入一个List集合
        ArrayList<Student> students = new ArrayList<>();
        String data = getData();
        String[] lines = data.split("\n");
        for (String line : lines) {
            students.add(new Student(line));
        }
        students.forEach(System.out::println);
        System.out.println("====================================");

        //2. 删除集合中所有的未成年的数据
        List<Student> collect = students.stream()
                .filter(x -> x.age >= 18)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("====================================");

        //3. 计算所有人的平均年龄、 最大年龄、 最小年龄
        IntSummaryStatistics intSummaryStatistics = students.stream()
                .mapToInt(Student::getAge)
                .summaryStatistics();
        double average = intSummaryStatistics.getAverage();
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        System.out.println("average = " + average + ", max = " + max + ", min = " + min);
        System.out.println("====================================");

        //4.1 将集合中的数据按照年龄进行降序排序； 如果年龄相同， 按照身高降序排序
        List<Student> collect2 = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed()
                        .thenComparing(Student::getHeight, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);
        System.out.println("====================================");

        //4.2 将集合中的数据按照年龄进行降序排序； 如果年龄相同， 按照身高降序排序
        students.sort((s1, s2) -> {
            if (s1.age.equals(s2.age)) {
                return s2.height - s1.height;
            }
            return s2.age - s1.age;
        });
        students.forEach(System.out::println);
        System.out.println("====================================");

        //5. 查询集合中所有的年龄在[20,25]范围内， 体重在[60,80]范围内的数据， 按照身高降序排列， 截取第2到第4名
        List<Student> collect1 = students.stream()
                .filter(s -> s.age >= 20 && s.age <= 25)
                .filter(s -> s.weight >= 60 && s.weight <= 80)
                .sorted((s1, s2) -> s2.height - s1.height)
                .limit(4)
                .skip(1)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }

    public static String getData() {
        return "name:xiaoming, age:10岁, gender:male, height: 172cm, weight: 70kg\n" +
                "age: 20岁, height: 177cm, name: xiaobai, weight: 80kg, gender: male\n" +
                "gender:female, height: 176, weight: 66, name:xiaolv, age:21\n" +
                "name: xiaohui, gender: female, height: 154cm, weight: 55kg, age: 13岁\n" +
                "age: 23, weight: 66kg, height: 177cm, name: xiaohei, gender: male\n" +
                "weight: 80kg, height: 188cm, name: alan, age: 24, gender: male\n" +
                "height: 176cm, weight: 77, age: 23, name: huihui, gender: female\n" +
                "name: baibai, gender: female, weight: 65kg, height: 177cm, age: 24岁\n" +
                "age: 30岁， gender: male, weight: 80kg, height: 177cm, name: heihei";
    }
}
