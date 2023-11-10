package basics;

/**
 * @program: draft
 * @description: try-catch-finally
 * @author: atong
 * @create: 2023-11-10 13:10
 */
public class Trycf {
        public static void main(String[] args) {
            String result = test();
            System.out.println(result);
        }
        public static String test() {
            try {
//                int a = 1/0;
                System.out.println("1");
//                int a = 1/0;
                return "4";
            } catch(Exception e) {
                System.out.println("2");
                return "5";
            } finally {
                System.out.println("3");
            }
        }
}
