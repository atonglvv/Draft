package regex;

/**
 * @program: draft
 * @description: 正则基本使用
 * @author: atong
 * @create: 2020-12-01 17:10
 */
public class RegexDemo {
    /**只允许用户输入数字1-9,字母a-z,A-Z,只能半角,不能有空格的正则表达式*/
    public static final String ONLY_LETTER_OR_NUMBER = "^[a-z0-9A-Z]+$";

    public static void main(String[] args) {
        String name = "fda3454";
        boolean containChinese = isOnlyLetterOrNumber(name);
        System.out.println(name + "是否只含有数字或字母:" + containChinese);
    }

    public static boolean isOnlyLetterOrNumber(String str){
        return str.matches(ONLY_LETTER_OR_NUMBER);
    }
}
