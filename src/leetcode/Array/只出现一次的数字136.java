package leetcode.Array;

import java.util.HashMap;

/**
 * 2020/12/28
 * 一个数组中其他数字都出现了两次，找出那个只出现了一次的数字
 */
public class 只出现一次的数字136 {
    public int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums){
            single ^= num;
        }
        return single;
    }
    public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for (int i = 0; i < nums.length; i++){
            if (hash.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return 0;
    }
}
