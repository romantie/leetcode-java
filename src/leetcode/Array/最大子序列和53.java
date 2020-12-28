package leetcode.Array;

/**
 * 最大子序列和，使用动态规划解决
 * 将前一个数字和现在数字相加，
 */
public class 最大子序列和53 {
    public int maxSubArray(int[] nums){
        //pre维护前一个最大的子序列之和
        //maxAns维护最大的子序列之和
        int pre = 0;
        int maxAns = nums[0];
        for (int x : nums){
            pre = Math.max(pre + x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
