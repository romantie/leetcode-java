package leetcode.面试题;

/**
 * 2020/11/14
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
 * 编写一个函数判定它们是否只需要一次(或者零次)编辑
 */
public class OneEditAway {
    //用双指针的方法，分别从两边到中间匹配，如果最终的长度小于1，返回true
    //如果两个字符一开始的长度就大于1，那么这两个字符一定不是经过一次操作得到的
    public static boolean oneEditWay(String frist,String second){
        if (frist.length()==0 || second.length()==0)
            return true;

        if (Math.abs(frist.length()-second.length())>1)
            return false;
        int len1 = frist.length();
        int len2 = second.length();
        int i=0;
        int j = len1-1;
        int k = len2-1;

        while (i<len1 && i<len2 && frist.charAt(i) == second.charAt(i)) {
            i++;
        }
        while (j>=0 && k>=0 && frist.charAt(j) == second.charAt(k)){
            --j;
            --k;
        }


        return j-i<2 && k-i<2;

    }

    public static void main(String[] args) {
        String frist = "ab";
        String sec = "bc";
        boolean oneEditWay = oneEditWay(frist, sec);
        System.out.println(oneEditWay);
    }
}
