package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 14:41
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 编写一段程序，要求打印出一段时时间内的闰年年份(while循环)
 */
public class LeapYear {
    //测试用例
    public static void main(String[] args) {
        new LeapYear().leapYear(0,2019);
    }

    public void leapYear(int begin,int end) {
        while(begin <= end) {
            if (begin % 4 == 0 && begin % 100 != 0) {
                System.out.println(begin);
            }
            begin++;
        }
    }
}
