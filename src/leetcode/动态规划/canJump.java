package leetcode.动态规划;

/**
 * 一只青蛙初始在0 处，每次跳到的位置上写着加一次可以条多远，
 * 最后是否能正好跳到重点
 */
public class canJump {
    /**
     *
     * @param A 跳的格数[3,2,0,5]
     * @return 是否能跳到
     */
    public static boolean canJumped(int[] A){
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;

        for (int i=1;i<n;i++){
            f[i] = false;
            for (int j=0;j<i;j++){
                if (f[j] && j+A[j] >= i){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4};
        boolean b = canJumped(A);
        System.out.println(b);
    }
}
