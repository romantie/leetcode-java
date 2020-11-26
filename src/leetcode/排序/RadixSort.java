package leetcode.排序;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 2020/11/16
 * 基数排序，
 */
public class RadixSort {
    public static void radixSort(int[] nums){
        //寻找最大值
        int max=nums[0];
        for (int i =1;i<nums.length;i++){
            if (max<nums[i]){
                max = nums[i];
            }
        }
        System.out.println(String.valueOf(max));
        //计算最高位有几位
        int maxFigure = 1;
        while(max/10 > 0){
            maxFigure++;
            max/=10;
        }
        System.out.println(String.valueOf(maxFigure));

        //初始化桶
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(10);
        for (int i=0;i<10;i++){
            bucket.add(new LinkedList<Integer>());
        }

        //进行每一趟的排序，最低位优先
        for (int i =1;i<=maxFigure;i++){
            //获取每一位的最后一位的值
            for (int num : nums) {
                //pow（x，y）求x的y次方
                int val = (num / (int) Math.pow(10, i - 1)) % 10;
                bucket.get(val).add(num);
            }
            //没一趟排序后将元素放入元素组
            int k=0;
            for (int j=0;j<10;j++){
                for (Integer x:bucket.get(j)){
                    nums[k++]= x;
                    //一趟排序以后将桶清空
                    bucket.get(j).clear();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,102,2,451,555,456,89,98};
        radixSort(nums);
        for (int i = 0;i<nums.length;i++){
            System.out.printf("%d ",nums[i]);
        }
        //System.out.println(nums.toString());
    }
}
