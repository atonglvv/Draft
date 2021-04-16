package exception;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-10 05:09
 */
public class TestExceptiona {
    public static void main(String[] args) {
        new TestExceptiona().a();
    }

    public void a () {
        try {

            try {
                b();
            } catch (Exception e) {
                if (e instanceof ArithmeticException) {
                    System.out.println("throw ArithmeticException");
                } else {
                    System.out.println("throw Exception");
                }
            }

        }catch (Exception e) {
            System.out.println("throw Exception aaa");
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
