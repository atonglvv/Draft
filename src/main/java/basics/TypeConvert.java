package basics;

/**
 * @Auther: carver
 * @Date: 2019/1/19 19:17
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 数据类型之间的转换
 */
public class TypeConvert {



    public static void main(String[] args) {

        /**
         * String --> int
         */
        int anInt;

        String a = "6";

        //方法1
        anInt = Integer.parseInt(a);
        //方法2
        anInt = Integer.valueOf(a).intValue();


        /**
         * int --> String
         */
        int aString = 6;

        String b;
        //方法1
        b = String.valueOf(aString);
        //方法2
        b = "" + aString;


    }

}
