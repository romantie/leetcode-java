package leetcode.字符串;

/**
 * 每天一题2020/11/25    1370
 * 上升下降字符串
 * 使用桶计数解决，自己了解桶排序
 *
 */
public class SortString1370 {
    public static String sortString(String s){
        //创建一个26大小的桶
        int[] bucket = new int[26];
        //将a,b,c等依次放入桶中并计数，
        for (int i = 0;i<s.length();i++){
            bucket[s.charAt(i)-'a']++;
        }
        //构建一个字符串来存储取出的字符，同时将桶中的数量减一
        StringBuffer stringBuffer = new StringBuffer();
        while(stringBuffer.length()<s.length()){
            //正着取一次
            for (int i=0;i<26;i++){
                if (bucket[i]>0){
                    stringBuffer.append((char)(i+'a'));
                    bucket[i]--;
                }
            }
            //反着取一次
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
