package basics;

import java.util.List;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-26 14:43
 */
public class DDDraft {
    public static void main(String[] args) {
        List<String> list = null;
        //npe
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(Math.round(-1.5));

    }
}
