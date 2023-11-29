import java.util.*;

/**
 * @program: draft
 * @description: 红球池1-33,随机取6个,蓝球池1-16,随机取1
 * @author: atong
 * @create: 2022-04-12 20:10
 */
public class Sort {
    public static void main(String[] args) {
        List<Integer> red = new ArrayList<>();
        List<Integer> bule = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            red.add(i);
        }
        for (int i = 1; i < 17; i++) {
            bule.add(i);
        }
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            int randomValue = random.nextInt(34 - i);
            System.out.println(red.remove(randomValue));
        }
        Random random = new Random();
        int randomValue = random.nextInt(17);
        System.out.println(bule.remove(randomValue));
    }
}
