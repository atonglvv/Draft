package string.api;

/**
 * @program: draft
 * @description: String传递
 * @author: atong
 * @create: 2021-01-20 17:41
 */
public class StringTransmit {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "bbb";
        String c = "ccc";

        transmit(a,b,c);

        transmit(a);

        System.out.println(a + b + c);
    }

    public static boolean transmit (String... strs) {
        for (String str : strs) {
            str = "ddd";
        }
        return false;
    }

    public static boolean transmit (String str) {
        str = "ddd";
        return false;
    }
}
