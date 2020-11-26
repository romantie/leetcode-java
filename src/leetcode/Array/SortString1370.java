package leetcode.Array;

/**
 * 每天一题2020/11/25    1370
 * 上升下降字符串
 * 使用桶计数解决，自己了解桶排序
 *
 */
public class SortString1370 {
    public static String sortString(String s){
        int[] bucket = new int[26];
        for (int i = 0;i<s.length();i++){
            bucket[s.charAt(i)-'a']++;
        }

        StringBuffer stringBuffer = new StringBuffer();
        while(stringBuffer.length()<s.length()){
            for (int i=0;i<26;i++){
                if (bucket[i]>0){
                    stringBuffer.append((char)(i+'a'));
                    bucket[i]--;
                }
            }
            for (int i = 25;i>=0;i--){
                if (bucket[i]>0){
                    stringBuffer.append((char)(i+'a'));
                    bucket[i]--;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbbcccddd";
        String s1 = sortString(s);
        System.out.println(s1);
    }
}
