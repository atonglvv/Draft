package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 16:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 实心菱形
 */
public class Diamond {

    public static void main(String[] args) {

        int size=5;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for (int i = 1; i <= size-1; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }

            for (int k = 2*size-3; k >= 2 * i - 1; k--){
                System.out.print('*');
            }
            System.out.println();
        }
    }


//    public static void main(String agrs[]) {
//        int line = 7;
//
//        for (int i = 1; i<= line; i++) {
//            if (i<= line / 2 + 1) {
//                for (int k = 1; k <= line / 2 + 1 - i; k++) {
//                    System.out.print(" ");
//                }
//                for (int k = 1; k <= i; k++) {
//                    System.out.print("* ");
//                }
//                System.out.println();
//            } else {
//                for (int k = 1; k <= (i - (line / 2 + 1)); k++) {
//                    System.out.print(" ");
//                }
//                for (int k = 1; k <= (2 * (line / 2 + 1) - i); k++) {
//                    System.out.print("* ");
//                }
//                System.out.println();
//            }
//        }
//    }
}
