package stream.example.issue;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description 二级订单状态
 * @author atong
 * @date 20:08 2022/11/7
 * @version 1.0.0.1
 **/
public enum SecondLevelOrderStatusEnum {

    /** 二级订单状态级订单状态 */
    SIGN_UP(1, "已报名", Arrays.asList(
        OrderStatusEnum.SIGN_UP.getCode(),
        OrderStatusEnum.STORE_CONFIRM.getCode(),
        OrderStatusEnum.RESIDENT_CONFIRM.getCode(),
        OrderStatusEnum.WAIT_BOOKING_BUS.getCode(),
        OrderStatusEnum.WAIT_BUS.getCode())),
    DEPARTED(2, "已发车", Arrays.asList(
        OrderStatusEnum.DEPARTED.getCode(),
        OrderStatusEnum.WAIT_INTERVIEW.getCode(),
        OrderStatusEnum.INTERVIEW_RESULT.getCode())),
    INTERVIEWED(3, "已面试", Arrays.asList(
        OrderStatusEnum.PREPARE_WORK.getCode(),
        OrderStatusEnum.WAIT_WORK.getCode())),
    WORKING(4, "在职中", Arrays.asList(
        OrderStatusEnum.WORKING.getCode(),
        OrderStatusEnum.LEAVE_ALARM.getCode())),
    COMPLETE_DEPARTURE(5, "已离职", Arrays.asList(
        OrderStatusEnum.COMPLETE_DEPARTURE.getCode())),
    CANCELED(6, "已取消", Arrays.asList(
        OrderStatusEnum.CANCEL_APPLY.getCode(),
        OrderStatusEnum.CANCEL_DEPART.getCode(),
        OrderStatusEnum.CANCEL_RECEPTION.getCode(),
        OrderStatusEnum.CANCEL_INTERVIEW.getCode(),
        OrderStatusEnum.CANCEL_ENTRY.getCode(),
        OrderStatusEnum.CANCEL_ORDER.getCode())),
    INTERVIEW_FAIL(7, "未通过", Arrays.asList(
        OrderStatusEnum.INTERVIEW_FAIL.getCode()));

    /** 二级订单状态 code */
    private Integer code;
    /** 二级订单状态 value */
    private String value;
    /** 订单三级状态列表 */
    private List<Integer> orderStatusCodes;

    SecondLevelOrderStatusEnum(Integer code, String value, List<Integer> orderStatusCodes) {
        this.code = code;
        this.value = value;
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

    public List<Integer> getOrderStatusCodes() {
        return orderStatusCodes;
    }

    public void setOrderStatusCodes(List<Integer> orderStatusCodes) {
        this.orderStatusCodes = orderStatusCodes;
    }

    public static SecondLevelOrderStatusEnum getEnum(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (SecondLevelOrderStatusEnum statusEnum : SecondLevelOrderStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }

    public static String getSecondLevelValueByOrderStatusCode(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (SecondLevelOrderStatusEnum statusEnum : SecondLevelOrderStatusEnum.values()) {
            if (statusEnum.getOrderStatusCodes().contains(code)) {
                return statusEnum.getValue();
            }
        }
        return null;
    }
}
