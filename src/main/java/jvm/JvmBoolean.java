package jvm;

/**
 * @Auther: carver
 * @Date: 2019/3/15 10:29
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 * java规范和JVM规范是分开的，java语言中有boolean类型，
 * 而jvm中则是使用int来实现boolean。java源文件一旦被javac编译成字节码文件以后，
 * 就从java地盘进入jvm地盘了，需要按照jvm的规矩办事了。
 */
public class JvmBoolean {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("Hello, Java!");
        }
        if (flag == true){
            System.out.println("Hello, JVM!");
        }
    }

}
