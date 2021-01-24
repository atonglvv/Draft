package framework.rpc.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: draft
 * @description: 用户实体类
 * @author: atong
 * @create: 2021-01-23 14:11
 */
@Data
public class User implements Serializable {
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
}
