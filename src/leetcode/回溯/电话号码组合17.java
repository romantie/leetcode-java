package leetcode.回溯;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 每个数字映射和手机一样，给出一个数字，找出所有可能的字母组合
 * 使用哈希加回溯的方法
 */
public class 电话号码组合17 {
    public static List<String> letterCombination(String digits){
        List<String> cominations = new ArrayList<String>();
        if (digits.length() == 0){
            return cominations;
        }
        HashMap<Character, String> phoneMap = new HashMap<>(){{
           put('2',"abc");
           put('3',"def");
           put('4',"ghi");
           put('5',"jkl");
           put('6',"mno");
           put('7',"pqrs");
           put('8',"tuv");
           put('9',"wxyz");
        }};
        backtrack(cominations,phoneMap,digits,0,new StringBuffer());
        return cominations;

    }
    public static void backtrack(List<String> combinations, Map<Character,String> phoneMap,String digits,int index,StringBuffer combination){
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = letterCombination(digits);
        System.out.println(strings.toString());
    }
}
