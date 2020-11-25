package basics;

/**
 * @Auther: carver
 * @Date: 2019/2/21 13:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Ms {
    public static void main(String[] args) {

        System.out.println(binary_to_integer("0110"));
    }

    static int binary_to_integer(String binary) {
        int x = 0;
        for(char c: binary.toCharArray()) {
            x = x * 2 + (c == '1' ? 1 : 0);
        }
        return x;
    }

}
