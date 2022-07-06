package thread.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Draft
 * @description: synchronized 来解决并发问题
 * @author: atong
 * @create: 2022-07-01 11:44
 */
public class SimpleDateFormatLockDemo {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                try {
                    Date parseDate;
                    String dateStrCheck;
                    String dateStr;
                    synchronized (simpleDateFormat) {
                        dateStr = simpleDateFormat.format(new Date());
                        parseDate = simpleDateFormat.parse(dateStr);
                        dateStrCheck = simpleDateFormat.format(parseDate);
                    }
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }
}
