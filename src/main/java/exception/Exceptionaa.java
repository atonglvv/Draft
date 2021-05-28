package exception;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-05-28 11:44
 */
public class Exceptionaa {
    public static void main(String[] args) {
        b();
    }

    public static void b () {
        try {
            int num = 6;
            try {
                num = num / 0;
            }catch (ArithmeticException e) {
                throw new ArithmeticException("num / 0");
            }
            System.out.println(num);
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            throw e;
        }catch (Exception e) {
            System.out.println("catch an Exception");
            throw e;
        }
    }
}
