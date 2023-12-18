package basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: draft
 * @description: draft
 * @author: atong
 * @create: 2021-08-24 19:44
 */
public class DDDDraft {
    public static void main(String[] args) {
        try {
            String timeEnd = "20210824192009";
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date time = null;
            try {
                time = dateFormat.parse(timeEnd);
                throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("catch");
                e.printStackTrace();
                throw e;
            }
        } catch (Exception e) {
            System.out.println("外层Exception");
        }
    }
}
