package sword.leetcode.linearlist.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: draft
 * @description:
 * Set Matrix Zeroes
 * Given a m × n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise[vt.设计;想出;发明;图谋;遗赠给, n.遗赠] a constant[n.常数;恒量] space solution?
 *
 * Solution
 * O(m＋n)空间的方法很简单，设置两个bool数组，记录每行和每列是否存在0。
 * 想要常数空间，可以复用第一行和第一列。
 * @author: atong
 * @create: 2021-02-19 11:29
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,0,6}, {3,6,2,8,5}, {0,3,5,6,9}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("============");
        setMatrixZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 额外存储空间方法
     * 如果矩阵中任意一个格子有零我们就记录下它的行号和列号，这些行和列的所有格子在下一轮中全部赋为零。
     * 1.我们扫描一遍原始矩阵，找到所有为零的元素。
     * 2.如果我们找到 [i, j] 的元素值为零，我们需要记录下行号 i 和列号 j。
     * 3.用两个 sets ，一个记录行信息一个记录列信息。
     * 4.最后，我们迭代原始矩阵，对于每个格子检查行 r 和列 c 是否被标记过，如果是就将矩阵格子的值设为 0。
     *
     * 空间复杂度 O(m+n)
     * @param matrix 矩阵
     */
    public static void setMatrixZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        //用两个 sets,一个记录行信息一个记录列信息。
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        //遍历matrix, 记录0所在的行列
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        //再次遍历数组，并使用行和列集更新元素。
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 我们可以用每行和每列的第一个元素作为标记，这个标记用来表示这一行或者这一列是否需要赋零。
     * 这意味着对于每个节点不需要访问 M+N 个格子而是只需要对标记点的两个格子赋值。
     *
     * 1.遍历整个矩阵，如果 cell[i][j] == 0 就将第 i 行和第 j 列的第一个元素标记。
     * 2.第一行和第一列的标记是相同的，都是 cell[0][0]，所以需要一个额外的变量告知第一列是否被标记，同时用 cell[0][0] 继续表示第一行的标记。
     * 3.然后，从第二行第二列的元素开始遍历，如果第 r 行或者第 c 列被标记了，那么就将 cell[r][c] 设为 0。这里第一行和第一列的作用就相当于方法一中的 row_set 和 column_set 。
     * 4.然后我们检查是否 cell[0][0] == 0 ，如果是则赋值第一行的元素为零。
     * 5.然后检查第一列是否被标记，如果是则赋值第一列的元素为零。
     *
     * @param matrix
     */
    public static void setMatrixZeroesI (int[][] matrix) {
        //使用额外变量 标记第一列是否被标记。同时继续使用 cell[0][0] 继续表示第一行的标记。
        Boolean isCol = false;
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < c; j++) {
                // If an element is zero, we set the first element of the corresponding[adj.相当的,相应的;一致的;通信的] row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
