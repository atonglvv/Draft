package mapstruct;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-06-22 16:35
 */
@Data
public class User {
    /** 毕业时间 */
    private LocalDateTime graduationTime;
}
