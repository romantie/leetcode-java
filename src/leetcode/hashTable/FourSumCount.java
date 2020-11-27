package leetcode.hashTable;

import java.util.HashMap;

/**
 * 给定几个数组，求出每个数组中相加和为零
 */
public class FourSumCount {
    public static int fourSumCount(int[] A ,int[] B,int[] C,int[] D){
        HashMap<Integer, Integer> countAB = new HashMap<>();
        for (int u :A){
            for (int v : B){
                countAB.put(u+v,countAB.getOrDefault(u+v,0)+1);

            }
        }
        int ans = 0;
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
