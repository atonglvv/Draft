package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 18:35
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 选择拍讯
 */
public class SortBase {
    public static void main(String[] args) {
        int nums[] = new int[] { 5, 8, 9, 7, 3, 1, 6, 4, 2 };
        for (int i = 0; i < nums.length - 1; i++) {
            for (int m = i + 1; m < nums.length; m++) {
                if (nums[i] > nums[m]) {
                    int temp = nums[i];
                    nums[i] = nums[m];
                    nums[m] = temp;
                }
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
