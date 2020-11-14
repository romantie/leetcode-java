package leetcode.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subsets78 {

    public  static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1<<nums.length);

        //先添加一个空的集合
        res.add(new ArrayList<>());
        for (int num:nums){
            //每遍历一个元素就在之前的子集中追加这个元素
            for (int i=0;i<res.size();i++){
                //遍历之前的子集，重新封装成一个新得子集
                List<Integer> list = new ArrayList<>(res.get(i));
                //在新得子集里追加这个元素
                list.add(num);
                //将新的子集追加到集合中去
                res.add(list);
            }
        }
        return res;

    }


    public static void main(String[] args) {
        /**
         * int[] nums = {1,2,3};
         *         List<List<Integer>> res = subsets(nums);
         *         Iterator<List<Integer>> iter = res.iterator();
         *         while(iter.hasNext()){
         *             System.out.println(iter.next());
         *         }
         */



    }
}
