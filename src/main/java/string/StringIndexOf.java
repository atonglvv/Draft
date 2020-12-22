package string;

/**
 * @Auther: carver
 * @Date: 2019/4/11 12:41
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 * String str=“abcsabadfba”,判断“ba”在str中出现的位置和次数
 * indexOf(String str, int fromIndex)   ->  查找指定字符或字符串在字符串中从index的地方开始找第一次出现地方的索引
 * str -> the substring to search for.
 * fromIndex -> the index from which to start the search.
 * ----------------------------------
 * indexOf(String str)  ->  查找指定字符或字符串在字符串中第一次出现地方的索引,未找到的情况返回 -1
 */
public class StringIndexOf {
    public static void main(String[] args) {
        String str = "abcsabadfba";
        int count = 0;
        int indexFrom = 0;
        while (str.indexOf("ba", indexFrom) != -1) {
            System.out.println("位置 " + str.indexOf("ba", indexFrom));
            indexFrom = str.indexOf("ba", indexFrom) + 1;
            count++;
        }
        System.out.println("次数 " + count);
    }
}
