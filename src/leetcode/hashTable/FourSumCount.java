package leetcode.hashTable;

import java.util.HashMap;

/**
 * 给定几个数组，求出每个数组中相加和为零
 * 将其分为两组，每组相加后判断正负即可。使用hashMap、
 */
public class FourSumCount {
    public static int fourSumCount(int[] A ,int[] B,int[] C,int[] D){
        //创建一个hashMap存储结果
        HashMap<Integer, Integer> countAB = new HashMap<>();
        //前两个相加，
        for (int u :A){
            for (int v : B){
                countAB.put(u+v,countAB.getOrDefault(u+v,0)+1);

            }
        }
        int ans = 0;
        //后两个相加然后判断是否和一组的结果相负
        for (int u :C){
            for (int v :D){
                if (countAB.containsKey(-u-v))
                    ans+=countAB.get(-u-v);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] A = {1,2};
        int [] B = {-2,-1};
        int [] C = {-1,2};
        int [] D = {0,2};
        int i = fourSumCount(A, B, C, D);
        System.out.println(i);
    }
}
