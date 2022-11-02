package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: draft
 * @description: String 与 LocalDateTime 相互转换
 * @author: atong
 * @create: 2022-11-02 22:37
 */
public class StringToLocalDateTime {
    public static void main(String[] args) {

        List<String> dateTimeStrList = new ArrayList<>();
        String s1 = "2022-11-02T16:54:39.7+08:00";
        String s2 = "2022-11-02T16:54:39.71+08:00";
        String s3 = "2022-11-02T16:54:39.711+08:00";
        String s4 = "2022-11-02T16:54:39+08:00";
        dateTimeStrList.add(s1);
        dateTimeStrList.add(s2);
        dateTimeStrList.add(s3);
        dateTimeStrList.add(s4);

        dateTimeStrList.forEach(str -> {
            LocalDateTime parse = LocalDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            System.out.println(parse);
            String dateStr = parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(dateStr);
            System.out.println("------");
        });


    }
}
