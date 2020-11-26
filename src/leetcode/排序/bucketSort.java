package leetcode.排序;

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/11/26
 * 在学一遍排序，第一道桶排序
 * 桶排序步骤
 * 1.找出最大最小值，确定桶的个数 2.初始化桶 3.对通道内部排序4.进行输出
 */
public class bucketSort {
    public static void sort_tong(int[] nums){
        //寻找数组中的最大最小值
        int max = nums[0];
        int min = nums[0];
        for (int i =0 ;i < nums.length;i++){
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }
        //初始化桶
        int bucketNum = (max-min)/nums.length+1;
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(bucketNum);
        for (int i=0;i<bucketNum;i++){
            bucket.add(new LinkedList<Integer>());
        }

        //将元素放入对应的桶中
        for (int i =0;i<nums.length;i++){
            int index = (nums[i]-min)/nums.length;
            bucket.get(index).add(nums[i]);
        }

        //对每个桶内部的元素排序
        for (int i =0 ;i<bucket.size();i++){
            Collections.sort(bucket.get(i));
        }

        //将元素输出
        int k = 0;
        for (LinkedList<Integer> in : bucket){
            for (Integer i : in)
                nums[k++] = i;
        }


    }

    public static void main(String[] args) {
        int[] nums={5,4,45,2,5,8};
        sort_tong(nums);
        for (int i =0;i<nums.length;i++){
            System.out.printf("%d ",nums[i]);
        }
    }
}
