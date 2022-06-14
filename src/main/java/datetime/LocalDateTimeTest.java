package datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2022-06-14 21:39
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        System.out.println("当前时间 = " + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒");

        // 获取指定日期
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.JUNE, 10, 23, 47,20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String format = localDateTime.format(formatter);
        System.out.println("localDateTime = " + format);
        // 两个LocalDateTime差值
        long hoursUntil = localDateTime.until(now, ChronoUnit.HOURS);
        System.out.println("hoursUntil = " + hoursUntil);
        if (hoursUntil < 24) {
            System.out.println( hoursUntil + "小时前");
        } else if (hoursUntil < 48) {
            System.out.println("昨天");
        } else if (hoursUntil < 72) {
            System.out.println("前天");
        } else {
            System.out.println("三天前");
        }

        // 减一整天
        LocalDateTime minus = now.minus(Period.ofDays(1));
        System.out.println("minus = " + minus);
    }
}
