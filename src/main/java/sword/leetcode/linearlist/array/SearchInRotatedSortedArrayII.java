package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description: Search in Rotated Sorted Array II
 * Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 * Solution:
 * 在Search in Rotated Sorted Array基础之上,允许元素重复。
 * 元素重复就要考虑array[l] = array[m] 或者 array[m] = array[r]的情况了。
 * 比如： [1,1,1,1,3] -> [1,3,1,1,1]
 * 若array[l] = array[m] 或者 array[m] = array[r]则left++
 * @author: atong
 * @create: 2021-01-16 20:48
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] array = {1,3,1,1,1,1,1};
        int search = search(array, 3);
        System.out.println(search);
    }

    public static int search(int[] array, int target) {
        if (null == array || array.length == 0) {
            return -1;
        }
        int first = 0, last = array.length -1;
        while (first != last) {
            int mind = first + (last - first) /2;
            if (array[mind] == target) {
                return mind;
            }
            if (array[first] < array[mind]) {
                //array[first] < array[mind],数组 first->mind为有序数组
                if (target >= array[first] && target < array[mind]) {
                    //如果target位于左侧有序数组中
                    last = mind;
                }else {
                    //如果target位于右侧数组,则更新first
                    first = mind + 1;
                }
            }else if (array[first] > array[mind]) {
                if (target > array[mind] && target <= array[last]) {
                    first = mind + 1;
                }else {
                    last = mind;
                }
            }else {
                first++;
            }
        }
        return -1;
    }
}
