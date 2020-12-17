package stream.action;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: draft
 * @description: 树结构实体类
 * @author: atong
 * @create: 2020-12-17 19:57
 */
@Data
@AllArgsConstructor
public class TreeEntity {

    private Integer id;

    private String name;

    private Integer parentId;

    private List<TreeEntity> childNodeList;

}
