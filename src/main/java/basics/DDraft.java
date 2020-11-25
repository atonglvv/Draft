package basics;

/**
 * @Auther: carver
 * @Date: 2019/1/30 22:28
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class DDraft {

    public int addOne(final int x) {
        return x;
    }

    public static void main(String[] args) {


        String str1 = "123",str2 = "123",str3 = new String("123");

        if (str1 == str2) {
            System.out.println("1");
        }
        if (str1 == str3) {
            System.out.println(2);
        }
        if (str1.equals(str2)) {
            System.out.println("3");
        }



        String sb = "hello";
        sb.length();
        int[] array = {1,2,3};
        int al = array.length;

        short s1 = 1;
//        s1 = s1 + 1;

        s1 += 1;

        int i;
        for (i = 0; i < 10; i++) {
            if (i > 6) {
                break;
            }
        }
            System.out.println(i);
    }
}
