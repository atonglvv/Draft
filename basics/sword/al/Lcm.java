package basics.sword.al;

/**
 * @Auther: carver
 * @Date: 2019/3/5 21:17
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Lcm {

    public static void main(String[] args) {

        System.out.println(getLcm(6, 9));
        System.out.println(getGcd(6,9));
    }

    public static int getLcm(int num1, int num2) {
        if (num2 == 0) {
            return  num1;
        }
        return getLcm(num2,num1 % num2);
    }
    public static int getGcd(int num1, int num2) {
        return num1 * num2 / getLcm(num1,num2);
    }


}
