package leetcode.排序;

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 2020/11/26
 * 每日一题，给定一个无序数组，找出排序数组间距最大的值，要求线性时间复杂度
 * 用基数排序解决
 */
public class MaximupGap164 {
    public static int maximumGap(int[] nums){
        if (nums.length<2) return  0;

        //找出最大值
        int max=0;
        for (int num : nums) {
            if (max < num)
                max = num;
        }
        //确定最大值的位数，即确定桶的个数
        int maxFigure=1;
        while (max/10 > 0){
            maxFigure++;
            max = max/10;
        }
        //初始化桶
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(maxFigure);
        for (int i =0;i<10;i++){
            bucket.add(new LinkedList<Integer>());
        }

        //进行排序
        for (int i = 1;i<=maxFigure;i++){
            for (int num : nums) {
                int index = (num / (int) Math.pow(10, i - 1)) % 10;
                bucket.get(index).add(num);
            }

            //将桶中的原数据放入桶中
            int k =0;
            for (int j=0;j<10;j++){
                for (Integer x : bucket.get(j))
                    nums[k++] = x;
                bucket.get(j).clear();
            }
        }

        int res = 0;
        for (int i=1;i<nums.length;i++){
            res = Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,10000,4};
        maximumGap(nums);
        for (int i=0;i<nums.length;i++){
            System.out.printf("%d ",nums[i]);
        }
    }
}
