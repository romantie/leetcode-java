package leetcode.hashTable;

import java.util.HashMap;

/**
 * 2020/12/27，
 * 单词规律，是205题同构字符串的稍微复杂版,由字符字符映射变为了字符和字符串映射
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 */
public class 单词规律290 {
    public static boolean workPattern(String pattern,String str){
        //构造两个hashMap来存储字符和字符串的双向映射
        HashMap<Character, String> chToStr = new HashMap<>();
        HashMap<String,Character> strToCh = new HashMap<>();

        int i = 0;
        int len = str.length();
        for (int k = 0; k < pattern.length(); ++k){
            char ch = pattern.charAt(k);
            //下面开始处理，str的字符串，i，j表示str中每个单词的区间
            if (i >= len){
                return false;
            }
            int j = i ;
            //通过判断空字符，可以得到str中的每一个单词的下标区间，
            while (j < len && str.charAt(j) != ' '){
                j++;
            }
            //temp即为2str中的每一个单词
            String temp = str.substring(i,j);
            //判断映射表中双向映射，如果已经有了映射关系但是却不于我们所要的关系，返回false
            if (strToCh.containsKey(temp) && strToCh.get(temp) != ch){
                return false;
            }
            if (chToStr.containsKey(ch) && !chToStr.get(ch).equals(temp)){
                return false;
            }
            chToStr.put(ch,temp);
            strToCh.put(temp,ch);
            i = j + 1 ;
        }
        return i>=len;
    }

    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean b = workPattern(pattern, str);
        System.out.println(b);
    }
}
