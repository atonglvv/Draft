package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * Rotate Image:
 * You are given an n × n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 *
 * Solution:
 * 首先想到，纯模拟，从外到内一圈一圈的转，但这个方法太慢。
 * 首先沿着副对角线翻转一次，然后沿着水平中线翻转一次。如图:RotateImage.png
 *
 * @author: atong
 * @create: 2021-02-06 10:16
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("====================");
        rotaI(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }



    public static void rota (int[][] matrix) {
        //副对角线互换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
                matrix[matrix.length-1-j][matrix.length-1-i] = temp;
            }
        }
        //沿着水平中线上下互换
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
    }

    public static void rotaI (int[][] matrix) {
        //沿着水平中线上下互换
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        //沿主对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j] = temp;
            }
        }
    }
}
