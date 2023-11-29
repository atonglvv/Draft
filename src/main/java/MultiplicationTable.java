/**
 * @program: draft
 * @description: 打印九九乘法表
 * @author: atong
 * @create: 2021-07-08 18:58
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i=1;i<=9;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
