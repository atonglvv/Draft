package json;

import com.alibaba.fastjson.JSON;
import common.Student;

/**
 * @program: draft
 * @description: 反序列化为对象
 * @author: atong
 * @create: 2021-04-28 21:49
 */
public class ParseObject {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("atong");
        student.setAge(19);

        //序列化为Json
        String studentStr = JSON.toJSONString(student);
        System.out.println(studentStr);
        //反序列化为 Student class
        Student studenta = JSON.parseObject(studentStr, Student.class);
        System.out.println(student.toString());
    }
}
