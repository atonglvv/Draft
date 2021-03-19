package basics;

/**
 * @program: draft
 * @description: case
 * @author: atong
 * @create: 2021-03-19 09:40
 */
public class CaseDemo {
    public static void main(String[] args) {
        int a = 3;

        switch (a) {

            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("x");
                break;
            default:
                break;
        }
    }
}
