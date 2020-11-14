package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.println;

/**
 * 2020/10/24，节日快乐，重写一下两数之和吧
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TowNum {

    public static int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalAccessException("no two sum");

    }

    public static void main(String[] args) throws IllegalAccessException {
        int[] nums={2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        for (int num:nums){
            System.out.printf("%d ",num);
        }
        System.out.println();
        for (int i:result){
            System.out.print(i);
        }
        System.out.println("输出完毕");

    }

}
