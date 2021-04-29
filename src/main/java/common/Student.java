package common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: carver
 * @Date: 2019/1/21 12:44
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: Student Entity
 * 以及关于 fastJson->@JSONField的用法
 */
@Data
public class Student {

    @JSONField(name = "name", ordinal = 1)
    private String name;

    @JSONField(ordinal = 0)
    private Integer age;

    @JSONField(format = "YYYY-MM-dd")
    private Date birthday;

    public Student() {}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
