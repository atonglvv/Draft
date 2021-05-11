package jvm.classload;

/**
 * @Auther: carver
 * @Date: 2019/2/22 14:40
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: JVM类加载时机：当初始化一个类时，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化
 */
public class Child extends Parent{
    static {
        System.out.println("Child 初始化。。。");
    }

    public static void main(String[] args) {

    }
}
