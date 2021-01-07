package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: draft
 * @description: String 中文相关
 * @author: atong
 * @create: 2021-01-07 15:04
 */
public class StringChinese {

    /**
     * 中文Pattern
     */
    private static final Pattern p = Pattern.compile("[\u4e00-\u9fa5]");

    public static void main(String[] args) {
        String name = "fdadsf";
        boolean containChinese = isContainChinese(name);
        System.out.println(name + "是否包含中文:" + containChinese);
    }

    /**
     * 判断String中是否包含中文
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Matcher m = p.matcher(str);
        return m.find();
    }
}
