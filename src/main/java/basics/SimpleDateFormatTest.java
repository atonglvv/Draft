package basics;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-10 00:24
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        String timeStemp = "";
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            // 日期转换为时间戳
            timeStemp = sf.format(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(timeStemp);
    }
}
