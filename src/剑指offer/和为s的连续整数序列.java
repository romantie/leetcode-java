package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 和为s的连续整数序列 {

    //使用滑动窗口
    public int[][] findContinuous(int target){
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int []> res = new ArrayList<>();

        while(i <= target/2){
            //如果目标值小有边界向右移动，反之左边界向左移动
            if (sum < target){
                //右边界向右移动
                sum += j;
                j++;
            }else if (sum > target){
                //左边界向右移动
                sum -= i;
                i++;
            }else {
                int[] arr = new int[j-1];
                for (int k = i; k < j; k++){
                    arr[k-i] = k;
                }
                res.add(arr);
                //左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
