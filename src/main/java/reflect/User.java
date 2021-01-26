package reflect;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-01-26 14:31
 */
public class User implements Serializable {
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }
}