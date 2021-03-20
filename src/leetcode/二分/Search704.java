package leetcode.二分;

import java.util.HashMap;

/**
 * 对应leetcode中的简单题，704和35
 * 二分法，给定一个数组个一个数字，在数组中找到数子的下标，如果没有，返回数字可以被
 * 插入的位置下标
 */
public class Search704 {
    public  static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int  mid = 0;
        while (low<=high){
            mid = (low+high)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (target<nums[mid]) high=mid-1;
            else low = mid+1;

        }
        return low;
    }

    public static int search2(int[] nums , int target){
        HashMap<Integer, Integer> intHashMap = new HashMap<>();
        for (int i =0;i<nums.length-1;i++){
            if(!intHashMap.containsValue(nums[i])){
                intHashMap.put(nums[i],i);
            }
        }
        if (intHashMap.containsKey(target)){
            return intHashMap.get(target);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,3,5,6};
        int target = 3;
        int search = search(nums, target);
        System.out.println(search);
        int search2 = search2(nums,target);
        System.out.println(search2);
    }
}
