package string.bytes;

import java.io.UnsupportedEncodingException;

/**
 * @program: draft
 * @description: getBytes method 相关操作
 * @author: atong
 * @create: 2020-12-18 16:19
 */
public class GetBytes {

    /**
     * 获取String在某一字符集下的长度
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "123abc";
        int num = a.getBytes("utf-8").length;
        System.out.println(num);
        a = "中文";
        num = a.getBytes("utf-8").length;
        System.out.println(num);
    }
}
