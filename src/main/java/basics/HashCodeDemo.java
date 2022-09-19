package basics;

/**
 * @program: Draft
 * @description:
 * @author: atong
 * @create: 2022-09-13 11:15
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        String s = Integer.toHexString("".hashCode());
        System.out.println(s);
    }
}
