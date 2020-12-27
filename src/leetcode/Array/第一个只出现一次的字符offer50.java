package leetcode.Array;

import java.util.HashMap;

/**
 * 2020/12/27
 * 找出字符串中第一个，只出现一次的字符
 * 1.使用hashMap，统计个数，如果发现值位1，直接返回
 * 2.String的indexOf方法，
 */
public class 第一个只出现一次的字符offer50 {
    public static char fristUniqChar(String s){
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char ch : s.toCharArray()){
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        }
        for (int i = 0;i < s.length() ; i++){
            if (hash.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }

        return ' ';
    }

    public static char fristUniqChar2(String s){
        for (int i=0; i<s.length();i++){
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = fristUniqChar(s);
        System.out.println(c);
    }
}
