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
        String name = "fdad中sf";
        boolean containChinese = isContainChinese(name);
        System.out.println(name + "是否包含中文:" + containChinese);
        String chinese = getChinese("fds哈lf中5fds文fdf");
        System.out.println(chinese);
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

    public static String getChinese(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher m = p.matcher(str);
        while (m.find()) {
            for(int i=0; i <= m.groupCount(); i++){
                sb.append(m.group(i));
                System.out.println(m.groupCount());
                System.out.println("start = " + m.start());
            }
        }
        return sb.toString();
    }
}
