package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * Trapping Rain Water:
 * Given n non-negative integers representing[vt. 代表；表现；描绘；回忆；再赠送] an elevation map[高度图] where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * Solution:
 * 看图：TrappingRainWater.png
 * 最简单的想法：对于每个元素都要考虑它能接多少雨水：
 * 第一个元素是0，能接0雨水
 * 第二个元素是1，能接0雨水
 * 第三个元素是0，能接1雨水
 * ...
 * 第六个元素是0，能接2雨水。
 * 可以看到，每个元素能接的雨水量是：当前位置左边最高的数与右边最高的数的最小值减去当前位置的数。
 * 例如第六个元素接水量为2 = min(2,3) - 0 = 2。
 * 总结：对于每个位置，都考虑其左边最高的墙和右边最高的墙即可。
 *
 * @author: atong
 * @create: 2021-02-04 11:28
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trapI(array);
        System.out.println(trap);
    }

    /**
     * 每个元素能接的雨水量是：当前位置左边最高的数与右边最高的数的最小值减去当前位置的数。
     * @param height 数组
     * @return 雨水量
     */
    public static int trap(int[] height) {
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int temp = 0;
        for (int i = 0; i < height.length; i++) {
            //找每个元素的左边最大值（含自身）
            temp = Math.max(temp, height[i]);
            left[i] = temp;
        }
        temp = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            //找每个元素的右边最大值（含自身）
            temp = Math.max(temp, height[i]);
            right[i] = temp;
        }
        for (int i = 0; i < height.length; i++) {
            //最小高度-自身高度
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }


    /**
     * 最优解
     * 双指针法:
     * 左右两端各设定一个指针，初始两堵墙。如果左端小于右端，则以右端为墙，当前值等于左墙和右墙的最小值减去当前值。
     * @param height
     * @return
     */
    public static int trapI (int[] height) {
        int result = 0;
        //声明左指针
        int left = 0;
        //声明右指针
        int right = height.length - 1;
        //声明左墙右墙
        int leftwall = 0, rightwall = 0;
        while (left < right) {
            // 右边高，则以右端为墙
            if (height[left] < height[right]) {
                //如果左墙也比当前位置高的话
                if (leftwall > height[left]) {
                    //面积就是两墙最低者减去当前位置的高度
                    result += Math.min(leftwall, height[right]) - height[left];
                } else {
                    //否则更新左墙
                    leftwall = height[left];
                }
                left++;
            } else {
                //如果右墙也比当前位置高的话
                if (rightwall > height[right]) {
                    result += Math.min(rightwall, height[left]) - height[right];
                } else {
                    rightwall = height[right];
                }
                right--;
            }
        }

        return result;
    }
}
