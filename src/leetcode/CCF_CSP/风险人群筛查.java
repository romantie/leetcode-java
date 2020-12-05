package leetcode.CCF_CSP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ccf csp2020/9第二题，风险人群筛查
 */
public class 风险人群筛查 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //n表示人数，k连续的点，t个点，range范围，nums每个人的轨迹记录
        int[][] range = new int[2][2];
        int[][] nums = new int[22][1000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        if (n<1 || n>20) return ;
        if (k<1 || k>1000) return;
        if (t<1 || t>1000) return;
        //对范围进行赋值
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                range[i][j] = sc.nextInt();
                if (Math.abs(range[i][j])>1000000)
                    return ;
            }
        }
        //对行动轨迹赋值
        for (int i=0; i<n;i++){
            for (int j=0;j<2*t;j++){
                nums[i][j] = sc.nextInt();
                if (Math.abs(nums[i][j])>1000000)
                    return ;
            }
        }
        list = seek(n,k,t,range,nums);
        for (Integer l :list){
            System.out.println(l);
        }
    }

    public static ArrayList<Integer> seek(int n, int k, int t, int[][] range, int[][] nums){
        ArrayList<Integer> list = new ArrayList<>();
        //分别表示路过和逗留的人数,s记录连续的坐标,s2表示如果有一个点符合则加一
        int walk = 0;
        int stay = 0;
        int s=0;
        int s2 = 0;
        for (int i=0 ; i<n ; i++){
            int j=0;
            while(j<t){
                //如果在范围内，就判断它后面连续的坐标是否在范围内
                if (nums[i][j]>=range[0][0] && nums[i][j]<=range[1][0] && nums[i][j+1]>=range[0][1] && nums[i][j]>=range[0][1]){
                    //如果在范围内就让s加一，s的值代表连续的数量，
                    s++;
                    j++;
                    s2++;
                    continue;
                }
                //每次碰到不连续的坐标之后，将s重新置为0；
                s=0;
                j++;
            }
            //在每一轮循环之后判断s和k，
            if (s>=k){
                stay++;
            }else if (s2>0){
                walk++;
            }

        }
        list.add(walk);
        list.add(stay);
        return list;
    }
}
