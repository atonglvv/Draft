package basics;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

/**
 * @Auther: carver
 * @Date: 2019/1/21 10:11
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
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



    }
}
