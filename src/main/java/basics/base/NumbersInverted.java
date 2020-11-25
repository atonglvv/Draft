package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/12 12:03
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 判断数字颠倒后是否跟源数字相等
 */
public class NumbersInverted {
    public boolean run(int num) {
        int s = 0;
        int bNum = num;
        int mod;
        boolean bz;

        while (bNum != 0) {
            mod = bNum % 10;
            s = s * 10 + mod;
            bNum = bNum / 10;
        }
        if (s == num) {
            bz = true;
        } else {
            bz = false;
        }
        return bz;
    }

    public static void main(String[] args) {
        NumbersInverted p = new NumbersInverted();
        System.out.println(p.run(123123));
        System.out.println(p.run(121));
        System.out.println(p.run(3333));
    }

}
