package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 15:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 打印100-999之内的所有水仙花数(水仙花数定义：个位数的立方+十位数的立方+ 百位数的立方 = 数字本身（使用while循环实现）
 */
public class Narcissus {

    public static void main(String[] args) {

        int base = 100;

        while(base < 1000){
            int single = base % 10;
            int ten = base / 10 % 10;
            int hundred = base /100;
            int singlet = single * single * single;
            int tent = ten * ten * ten;
            int hundredt = hundred * hundred * hundred;

            if (singlet + tent + hundredt == base) {
                System.out.println(base);
            }

            base ++;
        }
    }
}
