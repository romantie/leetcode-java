package leetcode.二分;

import java.util.Arrays;

/**
 * 2020/12/19 在排序数组中查找元素第一和最后一个位置
 * 给出的是有序数组，要求复杂度为logn，使用二分查找，
 */
public class 查元素第一和最后位置34 {
    public static int[] searchRange(int[] nums, int target){
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false) - 1;
        if (leftIndex <= rightIndex && rightIndex <= nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[] {leftIndex,rightIndex};
        }
        return new int[] {-1,-1};
    }

    public static int binarySearch(int [] nums,int target,boolean lower){
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while(left <= right){
            int mid = (left + right) / 2;
            //如果low为true，则=时即可执行，找到元素第一个出现的位置
            //反之，找到元素出现的最后一个位置的下一位
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid -1;
                ans = mid;
            } else {
                left = mid +1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {2,4,6,7,8,8,8,9,15};
        int target = 8;
        int[] s = searchRange(nums, target);
        System.out.println(Arrays.toString(s));
    }
}
