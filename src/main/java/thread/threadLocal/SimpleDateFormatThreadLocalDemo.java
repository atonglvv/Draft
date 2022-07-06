package thread.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-07-01 11:52
 */
public class SimpleDateFormatThreadLocalDemo {

    private static ThreadLocal<SimpleDateFormat> simpleDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        while (true) {
            try {
                new Thread(() -> {
                    String dateStr = simpleDateFormat.get().format(new Date());
                    try {
                        Date parseDate = simpleDateFormat.get().parse(dateStr);
                        String dateStrCheck = simpleDateFormat.get().format(parseDate);
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
            } finally {
                simpleDateFormat.remove();
            }
        }
    }
}
