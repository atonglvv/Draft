package regex;

/**
 * @program: draft
 * @description: 正则基本使用
 * matches() 方法用于检测字符串是否匹配给定的正则表达式。
 * 调用此方法的 str.matches(regex) 形式与以下表达式产生的结果完全相同：
 * Pattern.matches(regex, str)
 * @author: atong
 * @create: 2020-12-01 17:10
 */
public class RegexStringMatches {
    /**只允许用户输入数字1-9,字母a-z,A-Z,只能半角,不能有空格的正则表达式*/
    public static final String ONLY_LETTER_OR_NUMBER = "^[a-z0-9A-Z]+$";
    /**只允许用户输入数字1-9,字母a-z,A-Z,以及汉字,不能有空格的正则表达式*/
    public static final String ONLY_LETTER_OR_NUMBER_OR_CC = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";

    public static void main(String[] args) {
        String name = "fda3454";
        boolean containChinese = isOnlyLetterOrNumber(name);
        System.out.println(name + "是否只含有数字或字母:" + containChinese);


        String namea = "fda$中国";
        boolean check = namea.matches(ONLY_LETTER_OR_NUMBER_OR_CC);
        System.out.println(namea + "是否只包含字母与汉字:" + check);
    }

    /**
     * 检测字符串是否只含有数字以及大小写字母
     * @param str 字符串
     * @return 是否只含有数字与大小写字母
     */
    public static boolean isOnlyLetterOrNumber(String str){
        return str.matches(ONLY_LETTER_OR_NUMBER);
    }
}
