package string;

/**
 * @Auther: carver
 * @Date: 2019/1/19 16:18
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class StringEqualTest {

    public static void main(String[] args) {

        /**
         * 1.String类型的常量池:
         *     直接使用双引号声明出来的String对象会直接存储在常量池中。
         *     如果不是用双引号声明的String对象，可以使用String提供的intern方法。intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
         *
         *2.字符串的+操作其本质是创建了 StringBuilder 对象进行 append 操作，
         *  然后将拼接后的StringBuilder 对象用 toString 方法处理成 String 对象，
         *  这一点可以用 javap -c StringEqualTest.class 命令获得 class 文件对应的 JVM 字节码指令就可以看出来。
         */
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
