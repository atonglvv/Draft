package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-01-26 14:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public static Long sta;
    private Long id;
    /** 姓名 */
    public String name;
    /** 年龄 */
    private Integer age;

    public User(String name) {
        this.name = name;
    }

    private User(Integer age) {
        this.age = age;
    }
}