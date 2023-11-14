package sword;

/**
 * @program: draft
 * @description: 算法Demo类
 * @author: atong
 * @create: 2023-11-14 15:34
 */
public class SDemo {
    public static int btSteps(int target) {

        if (target <= 2) {
            return target;
        }
        return btSteps(target - 1) + btSteps(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(btSteps(10));
    }
}
