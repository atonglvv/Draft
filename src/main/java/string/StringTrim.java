package string;

/**
 * @program: draft
 * @description: string trim() 相关函数操作
 * 正常空格的ascii是32,但还有一种特殊空格的ascii是160
 * 注意 Java中的trim()只能去掉首尾ascii为32的正常空格。
 * @author: atong
 * @create: 2021-01-06 16:09
 */
public class StringTrim {
    public static void main(String[] args) {
        String name = "化妆水/爽肤水 i ";

        name = name.trim();
        System.out.println(name);

        //替换cell中的ascii为160的特殊空格为ascii为32的空格
        name = name.replaceAll("\\u00A0+", " ");

        name = name.trim();
        System.out.println(name);

        char space = ' ';
        System.out.println(space+'a'-'a');
    }
}
