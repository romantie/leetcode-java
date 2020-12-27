package leetcode.hashTable;

import java.util.HashMap;

/**
 * 2020/12/27
 * 给定两个字符串，abb，tff即为同构
 */
public class 同构字符串205 {
    public static boolean isIsomoriphic(String s,String t){
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (st.containsKey(x) && st.get(x) != y || ts.containsKey(y) && ts.get(y) != x ){
                return false;
            }
            st.put(x,y);
            ts.put(y,x);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "adds";
        String t = "hffe";
        boolean isomoriphic = isIsomoriphic(s, t);
        System.out.println(isomoriphic);
    }
}
