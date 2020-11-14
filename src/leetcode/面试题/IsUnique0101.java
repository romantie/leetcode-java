package leetcode.面试题;

import java.util.HashSet;

/**
 * 实现算法确定一个字符串的所有字符是否全都不同，
 * 尽量不适用别的数据结构
 */
public class IsUnique0101 {

    /**
     * 第一种解法，使用set判断是否重复
     * @param astr 输入的字符串
     * @return
     */
    public static boolean isUnique(String astr){
        HashSet<Character> strings = new HashSet<>();
        for (char i :astr.toCharArray()){
            if (strings.contains(i)){
                return false;
            }
            strings.add(i);
        }
        return true;
    }

    /**
     * 第二种解法，也就是题目考察的地方，使用位运算的方法判断是否有重复
     * @param args
     */
    public static void main(String[] args) {
        String str = "letasd";
        boolean unique = isUnique(str);
        System.out.println(unique);
    }
}
