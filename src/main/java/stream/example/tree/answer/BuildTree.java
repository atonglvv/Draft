package stream.example.tree.answer;

import com.alibaba.fastjson.JSON;
import stream.example.tree.issue.FirstLevelOrderStatusEnum;
import stream.example.tree.issue.OrderStatusEnum;
import stream.example.tree.issue.SecondLevelOrderStatusEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: Draft
 * @description: 构建树结构
 * @author: atong
 * @create: 2022-11-09 16:47
 */
public class BuildTree {
    public static void main(String[] args) {
        //一级状态
        List<CascaderVO> firstCascaders = Arrays.stream(FirstLevelOrderStatusEnum.values())
                .map(item -> new CascaderVO().setValue(item.getCode()).setLabel(item.getValue()))
                .collect(Collectors.toList());
        // 二级状态
        Map<Integer, List<OrderStatusEnum>> firstMap = Arrays.stream(OrderStatusEnum.values())
                .collect(Collectors.groupingBy(OrderStatusEnum::getFirstCode));
        // 三级状态
        Map<Integer, List<OrderStatusEnum>> secondMap = Arrays.stream(OrderStatusEnum.values())
                .collect(Collectors.groupingBy(OrderStatusEnum::getSecondCode));
        firstCascaders.forEach(item -> {
            Integer code = item.getValue();
            List<OrderStatusEnum> orderStatusEnums = firstMap.get(code);
            List<CascaderVO> seconds = orderStatusEnums.stream()
                    .map(itema -> new CascaderVO()
                            .setValue(itema.getSecondCode())
                            .setLabel(SecondLevelOrderStatusEnum.getEnum(itema.getSecondCode()).getValue()))
                    .distinct()
                    .collect(Collectors.toList());
            seconds.forEach(itemb -> {
                Integer codeb = itemb.getValue();
                List<OrderStatusEnum> secondList = secondMap.get(codeb);
                List<CascaderVO> collect = secondList.stream()
                        .map(itema -> new CascaderVO().setValue(itema.getCode()).setLabel(itema.getValue()))
                        .distinct()
                        .collect(Collectors.toList());
                itemb.setChildren(collect);
            });

            item.setChildren(seconds);
        });
        System.out.println(JSON.toJSONString(firstCascaders));
    }
}
