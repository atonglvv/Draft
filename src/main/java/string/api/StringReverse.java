package string.api;

/**
 * @Auther: carver
 * @Date: 2019/1/20 10:31
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 字符串反转
 */
public class StringReverse {

    public static void main(String[] args) {

        System.out.println(reverse("HelloWorld"));

    }

    //递归
    public static String reverse(String originStr) {

        if(originStr == null || originStr.length() <= 1) {
            return originStr;
        }

        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
