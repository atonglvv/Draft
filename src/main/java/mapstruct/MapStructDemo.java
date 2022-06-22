package mapstruct;

import com.alibaba.fastjson.JSON;
import lombok.val;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-06-22 16:39
 */
public class MapStructDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.JUNE, 10, 23, 47,20);
        student.setTime(localDateTime);
        students.add(student);
        Student student1 = new Student();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.JUNE, 10, 23, 47,20);
        student1.setTime(localDateTime1);
        students.add(student1);

        List<User> users = UserConverter.MAPPER.studentsToUsers(students);

        System.out.println("user = " + JSON.toJSONString(users));
    }
}
