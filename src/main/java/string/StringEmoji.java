package string;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: draft
 * @description: String 表情过滤
 * @author: atong
 * @create: 2021-12-24 15:39
 */
public class StringEmoji {

    private static final Pattern emojiPattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        String name = "😂 d中比😂sf";
        System.out.println("name.length = " + name.length());
        boolean containEmoji = isContainEmoji(name);
        System.out.println(name + "是否包含表情:" + containEmoji);
        String emoji = getEmoji(name);
        System.out.println(emoji);

        AtomicReference<String> delEmojiStr = new AtomicReference<>(delEmoji(name));
        System.out.println("删除字符串中的表情 = " + delEmojiStr);

        HashMap<Integer, String> hm = getEmojiIndex(name);

        System.out.println("hm = " + JSON.toJSONString(hm));
        hm.forEach((k, v) -> {
            String name1 = delEmojiStr.get().substring(0,k);
            String name2 = delEmojiStr.get().substring(k);
            delEmojiStr.set(name1 + v + name2);
            System.out.println(name1);
            System.out.println(name2);
        });
        System.out.println("最终的name = " + delEmojiStr);

    }

    /**
     * 判断String中是否包含表情
     *
     * @param str
     * @return
     */
    public static boolean isContainEmoji(String str) {
        Matcher m = emojiPattern.matcher(str);
        return m.find();
    }

    /**
     * @description 找出表情所处的index
     * @param str: 含表情的字符串
     * @return java.lang.String
     * @author atong
     * @date 2021/12/27 9:30
     * @version 1.0.0.1
     */
    public static String getEmoji(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher m = emojiPattern.matcher(str);
        while (m.find()) {
            for(int i=0; i <= m.groupCount(); i++){
                sb.append(m.group(i));
                System.out.println(m.groupCount());
                System.out.println("start = " + m.start());
            }
        }
        return sb.toString();
    }

    /**
     * @description 把表情从String中剔除
     * @param str: 含表情的字符串
     * @return java.lang.String
     * @author atong
     * @date 2021/12/27 9:47
     * @version 1.0.0.1
     */
    public static String delEmoji(String str) {
        Matcher m = emojiPattern.matcher(str);
        if (m.find()) {
            str = m.replaceAll("");
        }
        return str;
    }

    /**
     * @description 返回字符串中表情所属的index(key)与对应的表情(value)
     * @param str: 含表情的字符串
     * @return java.util.HashMap<java.lang.Integer,java.lang.String>
     * @author atong
     * @date 2021/12/27 9:48
     * @version 1.0.0.1
     */
    public static HashMap<Integer, String> getEmojiIndex(String str) {
        HashMap<Integer, String> hm = new HashMap<>();
        Matcher m = emojiPattern.matcher(str);
        while (m.find()) {
            for(int i=0; i <= m.groupCount(); i++){
                hm.put(m.start(), m.group(i));
            }
        }
        return hm;
    }
}
