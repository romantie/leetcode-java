package leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/12/27
 * 组合问题，使用回溯算法
 */
public class 组合78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums,int index,List<Integer> track){
        res.add(new ArrayList<>(track));
        for (int i = index; i < nums.length; i++){
            track.add(nums[i]);
            backtrack(nums, i+1,track);
            track.remove(track.size()-1);
        }
    }
}
