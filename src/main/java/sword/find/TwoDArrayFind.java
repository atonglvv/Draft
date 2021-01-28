package sword.find;

/**
 * @Auther: carver
 * @Date: 2019/1/30 16:55
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 * 题目描述：
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class TwoDArrayFind {

    /**
     * 解题思路：
     * 该二维数组中的一个数，它左边的数都比它小，下边的数都比它大。
     * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     * @param target
     * @param matrix
     * @return
     */
    public boolean find(int target,int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //首先确定矩阵的行与列
        int rows = matrix.length,cols = matrix[0].length;
        //从右上角开始查询，同理左下角
        int r = 0,c = cols - 1;
        //如果没出矩阵边界，则继续循环
        while (r <= rows - 1 && c >= 0) {
            //若正好相等，则返回true;若目标值大于矩阵值，则向下寻找r++;若目标值小于矩阵值，则向左寻找c--
            if (target == matrix[r][c]) {
                return true;
            }else if (target > matrix[r][c]) {
                r++;
            }else {
                c--;
            }
        }
        return false;
    }


}
