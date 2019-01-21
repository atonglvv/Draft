package basics;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

/**
 * @Auther: carver
 * @Date: 2019/1/21 10:11
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: ：Java 的时间日期 API 一直以来都是被诟病的东西，
 *                 为了解决这一问题，Java 8 中引入了 新的时间日期 API，
 *                 其中包括 LocalDate、LocalTime、LocalDateTime、Clock、Instant 等类
 */
public class DateAndTime {

    public static void main(String[] args) {

        /**
         * 获取年月日、时分秒
         * 创建 java.util.Calendar 实例，调用其 get()方法传入不同的参数即可获得参数所对应的值
         */
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    //0-11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        //Java8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     //1-12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());




        /**
         * 获取从1970年1月1日0时0分0秒到现在的毫秒数
         */
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());     //Java8




        /**
         * 获取某月的最后一天
         */
        Calendar time = Calendar.getInstance();
        System.out.println(time.getActualMaximum(Calendar.DAY_OF_MONTH));



        /**
         * 格式化时间
         */
        System.out.println(new Date());
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));

        System.out.println();

        //Java8
        System.out.println(LocalDate.now());
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format((newFormatter)));



        
        /**
         * 打印昨天的当前时刻
         */
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE,-1);
        System.out.println(cal2.getTime());

        //Java8
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);


    }
}
