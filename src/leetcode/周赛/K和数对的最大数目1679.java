package leetcode.周赛;

import java.util.Arrays;

/**
 *给定一个整数数组和一个整数k，选出和为k的两个整数
 * 类似两数之和，不过这里的数组可以有重复的值
 */
public class K和数对的最大数目1679 {
    public static int maxOperations(int[] nums,int k){
        int result=0;
        int low=0;
        int high=nums.length - 1;
        int sum = 0;
        Arrays.sort(nums);
        while(low < high){
            sum = nums[low] + nums[high];
            if (sum == k){
                result++;
                low++;
                high--;
            }else if (sum < k){
                low++;
            }else{
                high--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k=5;
        int i = maxOperations(nums, k);
        System.out.println(i);
    }
}
