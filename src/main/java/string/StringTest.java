package string;

import org.junit.Test;

/**
 * @program: draft
 * @description: String Test
 * @author: atong
 * @create: 2021-11-23 22:43
 */
public class StringTest {

    @Test
    public void test1(){
        String s1 = "a" + "b" + "c"; //常量与常量的拼接结果在常量池，原理是编译期优化。
        String s2 = "abc"; //"abc"一定放在字符串常量池中
        /*
         *最终.java编译成.class,再执行.class
         * string s1 = "abc";
         * string s2 = "abc";
         */
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop"; //编译器优化
        String s5 = s1 + "hadoop"; //只要其中有一个是变量，结果就在堆中。变量拼接的原理是stringBuilder。
        String s6 = "javaEE" + s2; //只要其中有一个是变量，结果就在堆中。变量拼接的原理是stringBuilder。
        String s7 = s1 + s2; //只要其中有一个是变量，结果就在堆中。变量拼接的原理是stringBuilder。
        /*
         * intern:
         * 判断字符串常量池中是否存在javaEEhadoop值
         * 如果存在，则返回常量池中javaEEhadoop的地址;
         * 如果不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回次对象的地址。
         */
        String s8 = s6.intern();

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        System.out.println(s3 == s8);
    }


    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /**
         * 如下的s1 + s2的执行细节:
         * StringBuilder s = new StringBuilder();
         * s.append("a")
         * s.append("b")
         * s.toString() --> 约等于 new String("ab")
         * 补充：jdk5.0之后使用的是StringBuild，在jdk5.0之前使用的是StringBuffer
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }


    @Test
    public void test4() {
        final String s1 = "a"; //常量与常量的拼接结果在常量池，原理是编译期优化。
        final String s2 = "b"; //常量与常量的拼接结果在常量池，原理是编译期优化。
        String s3 = "ab";
        /*
         * 字符串拼接操作不一定使用的是StringBuilder!
         * 如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
         */
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
    }


    @Test
    public void test5() {
        String s = new String("1");
        //调用此方法前，字符串常量中已经存在"1"了
        s.intern();
        String s2 = "1";
        //false
        System.out.println(s == s2);

        //s3变量的地址为：new String("11"),注意：下面这行代码不会在常量池中创建"11"对象
        String s3 = new String("1") + new String("1");
        /*
         * jdk6:创建了一个新的对象"11", 在永久代中  --> false
         * jdk7/8:常量池中并没有创建对象"11",而是创建了一个指向堆空间中new String("1")的地址  --> true
         */
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }


    @Test
    public void test6() {
        //s3变量的地址为：new String("11"),注意：下面这行代码不会在常量池中创建"11"对象
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        /*
         * jdk6:创建了一个新的对象"11", 在永久代中  --> false
         * jdk7/8:常量池中并没有创建对象"11",而是创建了一个指向堆空间中new String("1")的地址  --> true
         */
        s3.intern();
        String s5 = s3.intern();
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
    }

    @Test
    public void test7() {
        //new String("ab")
        String s = new String("a") + new String("b");
        /*
         * jdk6: 在字符串常量池中创建一个"ab"对象
         * jdk7/8: 字符串常量池中没有创建"ab"对象, 而是创建了一个引用, 指向new String("ab")
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");
        System.out.println(s == "ab");
    }

    @Test
    public void test8() {
        String x = "ab";
        //new String("ab")
        String s = new String("a") + new String("b");
        /*
         * jdk6: 在字符串常量池中创建一个"ab"对象
         * jdk7/8: 字符串常量池中没有创建"ab"对象, 而是创建了一个引用, 指向new String("ab")
         */
        String s2 = s.intern();
        System.out.println(s2 == "ab");
        System.out.println(s == "ab");
    }

}
