package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * Next Permutation[n.数排列; 数置换]:
 * Implement next permutation, which rearranges[vt.重新排列; 重新整理] numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement[n.布置; 整理; 准备; 安排] is not possible,
 * it must rearrange it as the lowest[adj.最低的; 最小的（low的最高级）; 最底下的] possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the
 * right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 在C++中提供了next_permutation全排列方法，
 * 所谓next_permutation全排列即将按字母表顺序生成给定序列的下一个较大的序列，直到整个序列为减序为止。
 * 设当前序列为pn，下一个较大的序列为pn+1，那么不存在pm，使得pn < pm < pn+1。
 * 而在java中没有此方法。
 *
 * Solution:
 * 1.From right to left, find the first digit (PartitionNumber)which violate[vt.违反;侵犯,妨碍;亵渎] the increase trend.
 * in this example, 6 will be selected since 8,7,4,3,2 already in a increase trend.
 * 2.From right to left, find the first digit which large than PartitionNumber, call it changeNumber.
 * Here the 7 will be selected.
 * 3.Swap the PartitionNumber and ChangeNumber.
 * 4.Reverse all the digit on the right of partition index.
 * 如图: src\main\java\sword\leetcode\linearlist\array\NextPermutation.jpg
 * @author: atong
 * @create: 2021-02-01 15:07
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] array = {6,8,7,4,3,2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * @description 下一个全排列
     * @param array: 数组
     * @return boolean
     * @author atong
     * @date 2021/2/2 10:28
     * @version 1.0.0.1
     */
    public static boolean nextPermutation(int[] array) {
        //沒有下一个全排列
        if(array.length <= 1) {
            return false;
        }
        //从右往左找，找到第一个不满足递增的数(要考虑到重复的数字)
        int partitionIndex = array.length - 2;
        while (partitionIndex >= 0 && array[partitionIndex] > array[partitionIndex + 1]) {
            partitionIndex--;
        }
        //该排列为有序排列,且为最大排列,比如[8,7,6,4,3,2]
        if(partitionIndex < 0) {
            Arrays.sort(array);
            return true;
        }

        //从右往左(直到partitionIndex)找，找到第一个比partitionNumber大的数
        int changeIndex = array.length - 1;
        while (array[changeIndex] < array[partitionIndex] && changeIndex > partitionIndex) {
            changeIndex--;
        }
        //交换arr[partitionIndex]和arr[changeIndex]
        swap(array, partitionIndex, changeIndex);
        //重新对arr[i]后面的数排序，接下来继续进行全排列操作
        Arrays.sort(array,partitionIndex + 1, array.length);
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        int t =array[i];
        array[i] = array[j];
        array[j] =t;
    }
}
