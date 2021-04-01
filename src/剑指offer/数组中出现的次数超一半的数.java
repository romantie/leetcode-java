package 剑指offer;

import java.util.HashMap;

public class 数组中出现的次数超一半的数 {

    public int numToHalf(int[] nums){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : nums){
            if (!hash.containsKey(i)){
                hash.put(i,hash.getOrDefault(i,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (hash.get(nums[i]) >= max){
                max = hash.get(nums[i]);
            }
        }
        int k = 0;
        for (k = 0; k < nums.length; k++){
            if (hash.get(nums[k]) == max){
                break;
            }

        }
        return nums[k];
    }

    //hash方法二
    public int numHalf(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for (int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if (map.get(i) > n){
                return i;
            }
        }
        return 0;
    }
}
