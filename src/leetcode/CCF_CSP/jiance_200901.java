package leetcode.CCF_CSP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2020/12/2
 * csp认证第一题，检测站问题，求距离最近的三个点
 *
 */
public class jiance_200901 {
    public static void main(String[] args){
        int X,Y;
        int n;
        int [][] location = new int[205][2];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        if (!(n>=3 && n<=200)) return;
        if (Math.abs(X)>1000 && Math.abs(Y)>1000) return;
        for (int i=0;i<n;i++){
            location[i][0] = sc.nextInt();
            location[i][1] = sc.nextInt();

            if(Math.abs(location[i][0])>1000 || Math.abs(location[i][1])>1000){
                return ;
            }
        }
        jiance(n,X,Y,location);
    }
    public static void jiance(int n, int X, int Y, int[][] location){
        double[] ans = new double[n];
        for (int i=0;i <n;i++){
            double n1 = Math.pow((X - location[i][0]), 2);
            double n2 = Math.pow(Y - location[i][1], 2);
            double sqrt = Math.sqrt(n1+n2);
            ans[i++] = sqrt;
        }
        double[] ans2 = new double[n];
        System.arraycopy(ans,0,ans2,0,ans.length);
        Arrays.sort(ans);
        for (int i=0;i<3;i++){
            for (int j=0;j<n;j++){
                if (ans2[j]==ans[i]){
                    System.out.println(j+1);
                    ans2[j] = -1;
                    break;
                }
            }
        }
    }
}
