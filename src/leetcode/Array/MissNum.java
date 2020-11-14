package leetcode.Array;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 思路一：排序实现
 */
public class MissNum {
    //排序，排除0，n没有出现，若在[0,n]中，前一个数字比后一个数字大2，则中间缺失的就是我们要找的
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        } else if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        for (int i = 1; i < nums.length; i++) {
            int expectionNum = nums[i-1] + 1;
            if (nums[i] != expectionNum) {
                return expectionNum;
            }
        }
        //如果没有缺失任何数字，返回-1
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,0,5};
        int expectionNum = missingNumber(nums);
        System.out.println(expectionNum);
    }
}
