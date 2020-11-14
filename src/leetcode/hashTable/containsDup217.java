package leetcode.hashTable;

import java.util.HashMap;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class containsDup217 {

    public static boolean contains(int[] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        //for (int i=0;i<nums.length;i++)
        for (int i:nums){
            if (hashMap.containsKey(i)){
                return true;
            }
            hashMap.put(i,1);
        }
        return false;

    }


    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        boolean res=contains(nums);
        System.out.println(res);

    }
}
