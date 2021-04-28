package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import common.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: draft
 * @description: 反序列化为集合 数组
 * @author: atong
 * @create: 2021-04-28 22:05
 */
public class ParseArray {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("atong");
        student.setAge(19);

        Student student1 = new Student();
        student1.setName("gf");
        student1.setAge(18);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        String s = JSON.toJSONString(students);
        System.out.println(s);

        List<Student> students1 = JSON.parseArray(s, Student.class);
        System.out.println(students1.toString());

    }
}
