package common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-01-26 14:31
 */
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    /** 姓名 */
    public String name;
    /** 年龄 */
    private Integer age;
}