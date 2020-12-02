package jvm;

/**
 * @Auther: carver
 * @Date: 2019/1/18 14:39
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */

class SingleTone {
    /**
     * 准备：
     *      singleTone ==> null
     *      count1 ==> 0
     *      count2 ==> 0
     *
     * 初始化：
     *      singleTone ==> new SingleTone(); ==> count1==1,count2==1;
     *      count1 ==1;
     *      count2 ==0;
     */
    private static SingleTone singleTone = new SingleTone();


    public static int count1;

    public static int count2 = 0;

//    private static SingleTone singleTone = new SingleTone();

    private SingleTone() {
        count1++;
        count2++;
    }

    public static SingleTone getInstance() {
        return singleTone;
    }
}

public class ClassLoader {

    public static void main (String[] args) {
        System.out.println("count1 = " + SingleTone.count1);
        System.out.println("count2 = " + SingleTone.count2);
    }
}
