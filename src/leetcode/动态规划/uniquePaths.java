package leetcode.动态规划;

/**
 * 一个网格方阵，机器人在最左上角，每次只能向下或向右走一格，
 * 她走到最右下角有几种走法
 */
public class uniquePaths {
    public static int paths(int m,int n){
        int[][] f = new int[m][n];
        int i,j;

        for (i =0;i<m;i++){
            for (j=0;j<n;j++){
                if (i==0 || j==0){
                    f[i][j] = 1;
                }
                else{
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n=2;
        int paths = paths(m, n);
        System.out.println(paths);
    }
}
