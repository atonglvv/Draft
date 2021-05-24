package exception;

/**
 * @program: draft
 * @description: 捕获try块里 手动throw的Exception
 * @author: atong
 * @create: 2021-05-24 14:57
 */
public class CatchThrowNew {

    public static void main(String[] args) {
        try {
            //手动 throw a exception
            throw new Exception("exception");
        }catch (Exception e) {
            //可以捕获到
            System.out.println("catch (throw new Exception)");
        }
    }
}
