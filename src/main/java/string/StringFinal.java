package string;

/**
 * @program: draft
 * @description: String 不变
 * @author: atong
 * @create: 2021-11-21 12:56
 */
public class StringFinal {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringFinal stringFinal = new StringFinal();
        stringFinal.change(stringFinal.str, stringFinal.ch);
        System.out.println(stringFinal.str);
        System.out.println(stringFinal.ch);
    }
}
