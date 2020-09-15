package basics.base;

import java.util.Scanner;

/**
 * @Auther: carver
 * @Date: 2019/4/13 09:26
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int temp = number;
        //存放质数
        int[] prime = new int[number];
        //存放结果
        int[] result = new int[number];

        //将number内的质数存放到数组prime中
        int k = 0;
        for (int i = 2; i <= number;i++) {
            int j;
            for (j = 2;j <= Math.sqrt(i);j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                prime[k++] = i;
            }
        }

        int m = 0;
        //将number质因数放到result数组中
        for (int i = 0; i < prime.length; i++) {
            if (prime[i] == 0) {
                break;
            }
            while(number % prime[i] == 0){
                result[m++] = prime[i];
                number /= prime[i];
            }
        }

        //打印结果
        System.out.print(temp + "=");
        for (int i = 0; i < result.length && result[i] != 0; i++) {
            if(i == 0) {
                System.out.print(result[i]);
            }else {
                System.out.print("*" + result[i]);
            }
        }

    }


}
