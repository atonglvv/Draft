package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * Remove Element:
 * Given an array and a value, remove all instances of that value[删除该值的所有实例] in place and return the new length.
 * The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 * @author: atong
 * @create: 2021-02-01 14:24
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 2, 3, 3, 6};
        int length = removeElement(nums, 3);
        System.out.println(length);
    }

    public static int removeElement(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[index++] = nums[i];
            }
        }
        //直接返回index,即为数组去重后的length
        return index;
    }
}
