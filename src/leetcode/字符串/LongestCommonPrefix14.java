package leetcode.字符串;

/**
 * 2020/11/27
 * 最长公共前缀
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0){
            return "";
        }
        //获取第0 个元素的长度
        int len = strs[0].length();
        //获取字符串的长度
        int count = strs.length;
        for (int i=0;i<len;i++){
            char c = strs[0].charAt(i);
            for (int j =1;j<count;j++){
                if (i==strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }
}
