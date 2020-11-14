package leetcode.hashTable;

import java.util.HashMap;

public class FindDiff389 {

    public static char findTheDifference(String s, String t) {

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (char i : s.toCharArray()) {
            hashMap.put(i, 1);
        }
        for (char i : t.toCharArray()) {
            if (t.length() == 1) {
                return t.toCharArray()[0];
            }
            if (!hashMap.containsKey(i)) {
                return i;
            }
        }
        return 'F';

    }

    public static char findTheDifference2(String s,String t){
        char res = 0;
        int lens = s.length();
        for (int i = 0; i < lens; i ++) {
            res ^= s.charAt(i)^ t.charAt(i);
        }
        res ^= t.charAt(lens);
        return res;
    }


    public static void main(String[] args) {
        String s ="ae";
        String t = "aea";
        System.out.println(t.toCharArray());
        char e = findTheDifference(s,t);
        char e2 = findTheDifference2(s,t);
        System.out.println(e2);
        System.out.println(e);

    }

}
