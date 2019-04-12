package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 12:41
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: String str=“abcsabadfba”,判断“ba”在str中出现的位置和次数
 */
public class StringBase {
    public static void main(String[] args) {
        String str = "abcsabadfba";
        int count = 0;
        int indexFrom = 0;
        while (str.indexOf("ba",indexFrom) != -1) {
            System.out.println("位置 " + str.indexOf("ba", indexFrom));
            indexFrom = str.indexOf("ba", indexFrom) + 1;
            count++;
        }
        System.out.println("次数 " + count);
    }
}
