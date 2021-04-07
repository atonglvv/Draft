package exception;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-07 14:30
 */
public class TestException {
    public static void main(String[] args) {
        new TestException().a();
    }

    public void a () {
        try {
            b();
        }catch (Exception e) {
            if (e instanceof ArithmeticException) {
                System.out.println("throw ArithmeticException");
            }else {
                System.out.println("thro Exception");
            }
        }
    }

    public void b () {
        try {
            int num = 6;
            try {
                num = num / 0;
            }catch (ArithmeticException e) {
                throw e;
            }
            System.out.println(num);
        } catch (Exception e) {
            throw e;
        }
    }
}
