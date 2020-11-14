package leetcode.面试题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 2020/11/14
 * 判断一个字符串是否一个回文字符的子字符
 * 简单来说只需要判断字符能否重复出现两次即可
 */
public class CanPermutePalindrome0104 {

    public static boolean canPermeutePalind(String s){
        Set<Character> set = new HashSet<Character>();
        for (char i:s.toCharArray()){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.size()<2;
    }


    public static void main(String[] args) {
        String s = "tactcoa";
        boolean b = canPermeutePalind(s);
        System.out.println(b);

    }
}
