package stream.example.tree.issue;

/**
 * @description  订单状态枚举
 * @author atong
 * @date 19:30 2022/11/7
 * @version 1.0.0.1
 **/
public enum OrderStatusEnum {

    /** 订单状态 */
    SIGN_UP(1, "已报名", 1, 1, 1),
    STORE_CONFIRM(2, "门店确认", 1, 1, 1),
    RESIDENT_CONFIRM(3, "驻场确认", 1, 1, 1),
    WAIT_BOOKING_BUS(4, "待约发车", 1, 1, 1),
    WAIT_BUS(5, "待发车", 1, 1, 1),
    DEPARTED(6, "已发车", 2, 2, 1),
    WAIT_INTERVIEW(7, "待面试", 2, 2, 1),
    INTERVIEW_RESULT(8, "面试结果", 2, 2, 1),
    PREPARE_WORK(9, "入职准备", 3, 3, 1),
    WAIT_WORK(10, "待入职", 3, 3, 1),
    WORKING(11, "在职中", 4, 4, 1),
    LEAVE_ALARM(12, "离职预警", 4, 4, 1),
    COMPLETE_DEPARTURE(13, "已离职", 4, 5, 2),
    CANCEL_APPLY(14, "取消报名", 1, 6, 2),
    CANCEL_DEPART(15, "取消发车", 1, 6, 2),
    CANCEL_RECEPTION(16, "取消接待", 2, 6, 2),
    CANCEL_INTERVIEW(17, "取消面试", 2, 6, 2),
    CANCEL_ENTRY(18, "取消入职", 3, 6, 2),
    CANCEL_ORDER(19, "取消订单", 0, 6, 2),
    INTERVIEW_FAIL(20, "面试失败", 3, 7, 2);

    /** 订单 status code */
    private Integer code;
    /** 订单 状态描述 */
    private String value;
    /** 首页进度条 code */
    private Integer progress;
    /** 二级状态 */
    private Integer secondCode;
    /** 一级状态 */
    private Integer firstCode;

    OrderStatusEnum(Integer code, String value, Integer progress, Integer secondCode, Integer firstCode) {
        this.code = code;
        this.value = value;
        this.progress = progress;
        this.secondCode = secondCode;
        this.firstCode = firstCode;
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

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getSecondCode() {
        return secondCode;
    }

    public void setSecondCode(Integer secondCode) {
        this.secondCode = secondCode;
    }

    public Integer getFirstCode() {
        return firstCode;
    }

    public void setFirstCode(Integer firstCode) {
        this.firstCode = firstCode;
    }

    public static OrderStatusEnum getByCode(Integer code){
        if (code == null){
            return null;
        }
        for (OrderStatusEnum enums : OrderStatusEnum.values()) {
            if (enums.getCode().equals(code)) {
                return enums;
            }
        }
        return null;
    }
}
