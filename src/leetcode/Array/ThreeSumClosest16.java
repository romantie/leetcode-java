package leetcode.Array;

import java.util.Arrays;

/**
 * 最接近的三数之和,与三数之和类似，排序加双指针
 */
public class ThreeSumClosest16 {
    public int threeSumClose(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int best=10000;
        //枚举
        for (int i = 0;i < n;++i){
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            //使用双指针枚举
            int j = i+1,k=n-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return target;
                }

                //根据差值更新答案
                if (Math.abs(sum-target) < Math.abs(best-target)){
                    best = sum;
                }
                if (sum > target){
                    int k0 = k-1;
                    while (j<k0 && nums[k0]==nums[k]) --k0;
                    k=k0;
                } else {
                   int j0 = j+1;
                   while (j0<k && nums[j0] == nums[j]) ++j0;
                   j=j0;
                }
            }
        }
        return best;
    }
}
