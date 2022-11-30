package stream.example.tree.answer;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @program: work-parent-pom
 * @description: 订单状态三级
 * @author: atong
 * @create: 2022-11-09 16:57
 */
@Data
@Accessors(chain = true)
public class CascaderVO {
    private Integer value;
    private String label;
    private List<CascaderVO> children;
}
