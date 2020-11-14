package leetcode;

import java.util.HashMap;

public class IntToRoman12 {

    public String intToRoman(int num) {

        HashMap<Character, Integer> chHashMap = new HashMap<>();
        chHashMap.put('I', 1);
        chHashMap.put('V', 5);
        chHashMap.put('X', 10);
        chHashMap.put('L', 50);
        chHashMap.put('C', 100);
        chHashMap.put('D', 500);
        chHashMap.put('M', 1000);


        return "";
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> chHashMap = new HashMap<>();
        chHashMap.put('I', 1);
        chHashMap.put('V', 5);
        int e = chHashMap.get('V');
        //System.out.println(e);
    }
}
