package stream.example.answer;

import stream.example.issue.FirstLevelOrderStatusEnum;
import stream.example.issue.OrderStatusEnum;

import java.util.ArrayList;
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
//        Map<Integer, String> collect = Arrays.stream(FirstLevelOrderStatusEnum.values())
//                .collect(Collectors.toMap(FirstLevelOrderStatusEnum::getCode, FirstLevelOrderStatusEnum::getSecondOrderStatusCodes));

        // 三级状态
        List<CascaderVO> thirdCascaders = new ArrayList<>();
        Arrays.stream(OrderStatusEnum.values()).forEach(item -> {
            CascaderVO cascaderVO = new CascaderVO();
            cascaderVO.setValue(item.getCode());
            cascaderVO.setLabel(item.getValue());
        });

        // 二级状态
        Map<Integer, List<OrderStatusEnum>> collect = Arrays.stream(OrderStatusEnum.values()).collect(Collectors.groupingBy(OrderStatusEnum::getSecondCode));

        //一级状态
        List<CascaderVO> firstCascaders = Arrays.stream(FirstLevelOrderStatusEnum.values())
                .map(item -> new CascaderVO().setValue(item.getCode()).setLabel(item.getValue()))
                .collect(Collectors.toList());

        return null;
    }
}
