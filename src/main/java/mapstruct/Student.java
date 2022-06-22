package mapstruct;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-06-22 16:38
 */
@Data
public class Student {
    /** 毕业时间 */
    private LocalDateTime time;
}
