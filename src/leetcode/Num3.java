package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Num3 {

    public  static int lengthOfLongestSubstring(String s) {
        //建立一个hashset看其是否有重复字符
        Set<Character> strings = new HashSet<Character>();
        int n=s.length();
        //rk右指针，初始值位-1，ans记录最后的字符长度
        int rk=-1,ans=0;
        for (int i=0;i<n;i++){
            if (i!=0){
                strings.remove(s.charAt(i-1));
            }
            while(rk+1<n && !strings.contains(s.charAt(rk+1))){
                strings.add(s.charAt(rk+1));
                ++rk;
            }
            //第i到rk个字符是一个无重复的字符
            ans = Math.max(ans,rk-i+1);
        }
        return ans;


    }
    public static int leng(String s){
        //建立一个hashset存储字符，判断是否有重复字符
        HashSet<Character> strings = new HashSet<Character>();
        int n=s.length();
        //rk位右指针，初始值为0
        int rk=0,ans=0;
        if (s.equals(" ")) return 1;
        for (int i=0;i<n;i++){
            if (i!=0){
                strings.remove(s.charAt(i-1));
            }
            while(rk<n && !strings.contains(s.charAt(rk))){
                strings.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans,rk-i);
        }

        return ans;
    }

    public static void main(String[] args) {
        String strings = "c";
        int an2 = leng(strings);
        int ans = lengthOfLongestSubstring(strings);
        System.out.println(an2);


    }
}
