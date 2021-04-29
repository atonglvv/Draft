package common;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: carver
 * @Date: 2019/1/21 12:44
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Data
public class Student {

    private String name;
    private Integer age;
    private Date birthday;

    public Student() {}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
