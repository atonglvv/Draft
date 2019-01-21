package basics;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: carver
 * @Date: 2019/1/21 10:06
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Code {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /**
         * 将GB2312编码的字符串转换为ISO-8859-1编码的字符串
         */
        String s1 = "你好";
        String s2 = new String(s1.getBytes("GB2312"),"ISO-8859-1");

    }

}
