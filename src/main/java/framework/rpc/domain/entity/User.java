package framework.rpc.domain.entity;

import lombok.Data;

/**
 * @program: draft
 * @description: 用户实体类
 * @author: atong
 * @create: 2021-01-23 14:11
 */
@Data
public class User {
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;
}
