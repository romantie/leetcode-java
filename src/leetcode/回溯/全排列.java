package leetcode.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class 全排列 {
    //保存结果
    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;

    }

    /**
     *
     * @param nums 选择列表
     * @param track 路径
     */
    public static void backtrack(int[] nums,LinkedList<Integer> track){
        //触发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return ;
        }
        for (int i = 0; i < nums.length ; i++){
            //排除不合法选择
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            backtrack(nums,track);
            //取消选择
            track.remove();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
