package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * Search in Rotated Sorted Array
 * Suppose a sorted array is rotated[旋转的/循环的] at some pivot[中心点/以什么为中心] unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume[设想/假设] no duplicate exists in the array.
 * Solution:
 * 二分查找,难度主要在于左右边界的确定。
 * 该题难点在于数组以某个中心点进行旋转。
 * 虽然比普通有序数组多一步旋转的操作,但旋转后的数组二分的话,肯定至少有一边是有序的。
 * 试想一下,若pivot位于数组的中点,则旋转之后数组左右两边都是有序的。
 * 若pivot位于数组的左边,则旋转之后数组左边是有序的。
 * 若pivot位于数组的右边,则旋转之后数组右边是有序的。
 * 该题还有一个重点,
 * 若array[left] < array[mind]则mind左侧是有序的;
 * 若array[mind] < array[right]则mind右侧是有序的。
 * 若 target 位于有序侧,则跟普通二分无区别。
 * 若 target 位于无序侧,则需要 left+1或者right-1,直到 left -> right 为有序数组。
 * @author: atong
 * @create: 2021-01-16 17:30
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        int search = search(array, 7);
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
            }else {
                if (target > array[mind] && target <= array[last]) {
                    first = mind + 1;
                }else {
                    last = mind;
                }
            }
        }
        return -1;
    }
}
