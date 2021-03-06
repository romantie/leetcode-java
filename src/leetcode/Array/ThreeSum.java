package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020/11/23
 *排序加双指针，先将数组进行排序然后使用双指针，一左一右，遍历相加，
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len<3) return ans;
        Arrays.sort(nums);
        for (int i =0;i<len;i++){
            //如果第一个数字大于0，那么三数之和必定大于0
            if (nums[i] > 0 ) break;
            //去重
            if (i>0 && nums[i]==nums[i-1]) continue;
            //定义两个指针
            int L=i+1;
            int R=len-1;
            while(L<R){
                int sum = nums[i] + nums[L] +nums[R];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }

        }
        return ans;
    }

}
