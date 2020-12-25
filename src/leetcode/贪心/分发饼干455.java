package leetcode.贪心;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2020/12/25，今天圣诞节，一个人度过，hhh
 * 分发饼干，给出两个数组，一个是孩子的胃口，一个是饼干的大小，
 * 判断最多能满足几个孩子的胃口
 */
public class 分发饼干455 {
    public static int findContentChildern(int[] g,int[] s){

        Arrays.sort(g);
        Arrays.sort(s);

        int numCookies = s.length;
        int numChildern = g.length;
        int count = 0;

        for(int i = 0,j = 0;i < numChildern && j < numCookies; i++, j++){
            while(j < numCookies && g[i] > s[j]){
                j++;
            }
            if(j < numCookies){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int [] g = {1,2,3};
        int[] s = {1,1};
        int contentChildern = findContentChildern(g, s);
        System.out.println(contentChildern);
    }

}
