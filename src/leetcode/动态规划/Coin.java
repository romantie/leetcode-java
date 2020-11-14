package leetcode.动态规划;

/**
 * 给定2，5，7三个数字，给定一个数字，求出凑成数字的最少
 *
 */
public class Coin {

    /**
     * @param A 有几个数字
     * @param M 给定一个数字
     * @return 最少需要多少数字相加
     */
    public int coinChange(int[] A,int M){
        int[] f = new int[M+1];
        int n= A.length;

        f[0]=0;

        int i,j;
        for (i =1;i<=M;++i){
            f[i] = Integer.MAX_VALUE;
            for (j=0;j<n;++j){
                if (i>=A[j] && f[i-A[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-A[j]]+1,f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE){
            f[M] = -1;
        }
        return f[M];

    }
}
