package leetcode.指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和，与三数之和类似，
 * 采用排序加双指针，将前两个元素遍历出来，然后使用双指针选出最后两个元素，
 * 途中采去一些剪枝操作减少遍历
 * 在确定第一个数之后，如果前四个数大于目标值，如果最后三个和第一个数相加比目标值小，则不可能会等于目标值
 * 在确定两个数之后如果前两个数相加，在类比前一次的相加，小于或者大于，都不可能产生目标值的数组
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int nums[], int target){
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length<4) return lists;
        //对数组进行排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i =0;i<length-3;i++){
            //进行剪枝，重复则跳过本次循环，如果前四个数大于目标值不可能等于目标值，后三个和第一个值小于目标值，也不会有值符合
            if (i>0 && nums[i] == nums[i-1]) continue;
            if (nums[i] + nums[i+1] +nums[i+2] + nums[i+3] >target) break;
            if (nums[i] + nums[length-3] + nums[length-2] + nums[length-1]<target) continue;
            for (int j =i+1 ;j<length-2;j++){
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                if (nums[i] + nums[j] +nums[j+1] + nums[j+2] > target) break;
                if (nums[i] + nums[j] + nums[length-2] +nums[length-1] < target) continue;
                //定义左右指针
                int left=j+1;
                int right = length-1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right && nums[left] == nums[left+1]) left++;
                        while (left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }else if (sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }

        }
        return lists;

    }
}
