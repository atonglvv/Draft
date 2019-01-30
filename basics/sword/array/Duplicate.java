package basics.sword.array;

/**
 * @Auther: carver
 * @Date: 2019/1/30 15:01
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 题目描述：
 *              在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *              数组中某些数字是重复的，但不知道有几个数字是重复的。
 *              也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *              例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *              该题也可使用boolean数组来记录各个元素重复情况。。
 */
public class Duplicate {

    public static boolean duplicate(int[] nums, int length, int[] duplication) {

        if(nums == null || length <= 0) {
            return false;
        }

        /**
         * 解题思路：
         * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
         */
        for(int i = 0;i < length; i++) {
            //如果下标为i的元素不为i,则与 以该元素为下标的元素 交换
            while (nums[i] != i) {
                //如果有相同元素，则返回改元素并 return true
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }

        return false;

    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        //测试用例{2, 3, 1, 0, 2, 5}
        int[] nums = {0, 2, 1, 2, 0, 5};
        int length = 6;
        int[] duplication = {0};

        System.out.println(duplicate(nums,length,duplication));
        System.out.println(duplication[0]);
    }




}
