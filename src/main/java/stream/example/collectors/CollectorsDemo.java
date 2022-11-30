package stream.example.collectors;

import com.alibaba.fastjson.JSON;
import common.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-11-30 15:31
 */
public class CollectorsDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 18));
        students.add(new Student("李四", 21));
        students.add(new Student("王五", null));
        students.add(new Student(null, 19));
        // Collectors.toMap 如果 value 为 null 则会导致 npe
        Map<Integer, String> collect = students.stream().collect(Collectors.toMap(Student::getAge, Student::getName));

        HashMap<Integer, String> collect1 = students.stream()
                .collect(HashMap::new, (map, student) -> map.put(student.getAge(), student.getName()), HashMap::putAll);
        System.out.println(JSON.toJSON(collect1));
    }
}
