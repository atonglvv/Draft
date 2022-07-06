package thread.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Draft
 * @description: SimpleDateFormatDemo
 * @author: atong
 * @create: 2022-07-01 11:22
 */
public class SimpleDateFormatDemo {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                String dateStr = simpleDateFormat.format(new Date());
                try {
                    Date parseDate = simpleDateFormat.parse(dateStr);
                    String dateStrCheck = simpleDateFormat.format(parseDate);
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
