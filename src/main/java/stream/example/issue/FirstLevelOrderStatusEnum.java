package stream.example.issue;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description  一级订单状态
 * @author atong
 * @date 20:08 2022/11/7
 * @version 1.0.0.1
 **/
public enum FirstLevelOrderStatusEnum {

    /** 一级订单状态 */
    IN_PROGRESS(1, "进行中",
            Arrays.asList(
                    SecondLevelOrderStatusEnum.SIGN_UP.getCode(),
                    SecondLevelOrderStatusEnum.DEPARTED.getCode(),
                    SecondLevelOrderStatusEnum.INTERVIEWED.getCode(),
                    SecondLevelOrderStatusEnum.WORKING.getCode()
            ),
            Arrays.asList(
                OrderStatusEnum.SIGN_UP.getCode(),
                OrderStatusEnum.STORE_CONFIRM.getCode(),
                OrderStatusEnum.RESIDENT_CONFIRM.getCode(),
                OrderStatusEnum.WAIT_BOOKING_BUS.getCode(),
                OrderStatusEnum.WAIT_BUS.getCode(),
                OrderStatusEnum.DEPARTED.getCode(),
                OrderStatusEnum.WAIT_INTERVIEW.getCode(),
                OrderStatusEnum.INTERVIEW_RESULT.getCode(),
                OrderStatusEnum.PREPARE_WORK.getCode(),
                OrderStatusEnum.WAIT_WORK.getCode(),
                OrderStatusEnum.WORKING.getCode(),
                OrderStatusEnum.LEAVE_ALARM.getCode()
            )
    ),
    COMPLETED(2, "已完成",
            Arrays.asList(
                    SecondLevelOrderStatusEnum.COMPLETE_DEPARTURE.getCode(),
                    SecondLevelOrderStatusEnum.CANCELED.getCode(),
                    SecondLevelOrderStatusEnum.INTERVIEW_FAIL.getCode()
            ),
            Arrays.asList(
                OrderStatusEnum.COMPLETE_DEPARTURE.getCode(),
                OrderStatusEnum.CANCEL_APPLY.getCode(),
                OrderStatusEnum.CANCEL_DEPART.getCode(),
                OrderStatusEnum.CANCEL_RECEPTION.getCode(),
                OrderStatusEnum.CANCEL_INTERVIEW.getCode(),
                OrderStatusEnum.CANCEL_ENTRY.getCode(),
                OrderStatusEnum.CANCEL_ORDER.getCode(),
                OrderStatusEnum.INTERVIEW_FAIL.getCode()
            ));

    /** 一级订单状态 code  */
    private Integer code;
    /** 一级订单状态 value */
    private String value;
    /** 二级订单状态 codes */
    private List<Integer> secondOrderStatusCodes;
    /** 订单三级状态列表 */
    private List<Integer> orderStatusCodes;

    FirstLevelOrderStatusEnum(Integer code, String value, List<Integer> secondOrderStatusCodes, List<Integer> orderStatusCodes) {
        this.code = code;
        this.value = value;
        this.secondOrderStatusCodes = secondOrderStatusCodes;
        this.orderStatusCodes = orderStatusCodes;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Integer> getSecondOrderStatusCodes() {
        return secondOrderStatusCodes;
    }

    public void setSecondOrderStatusCodes(List<Integer> secondOrderStatusCodes) {
        this.secondOrderStatusCodes = secondOrderStatusCodes;
    }

    public List<Integer> getOrderStatusCodes() {
        return orderStatusCodes;
    }

    public void setOrderStatusCodes(List<Integer> orderStatusCodes) {
        this.orderStatusCodes = orderStatusCodes;
    }

    public static FirstLevelOrderStatusEnum getEnum(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (FirstLevelOrderStatusEnum statusEnum : FirstLevelOrderStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }
}
