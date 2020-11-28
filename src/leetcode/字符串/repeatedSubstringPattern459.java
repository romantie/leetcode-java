package leetcode.字符串;

import javax.swing.text.AttributeSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 2020/11/28
 * 重复字符串，判断一个字符串是或否可以由它的一个字串重复多次构成
 */
public class repeatedSubstringPattern459 {
    public static boolean repeatedPattern(String s){
        if (s.length() == 1) return false;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (Character c:s.toCharArray()){
            hash.put(c,hash.getOrDefault(c, 0)+1);

        }
        int sum=0;
        int size = hash.size();
        int v=0;
//        Collection<Integer> values = hash.values();
//        Iterator<Integer> it = values.iterator();
//        while(it.hasNext()){
//            v=it.next();
//            System.out.println(v);
//            sum += it.next();
//        }
//        for (int va :values){
//            v = va;
//            sum+=va;
//        }
        for (int va :hash.values()){
            v = va;
            sum+=va;
        }
        return sum/v==size;
    }

    public static void main(String[] args) {
        String hashMap = "abcabcabcabc";
        boolean b = repeatedPattern(hashMap);
        System.out.println(b);
    }

}
