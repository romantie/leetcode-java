package leetcode.指针;

/**
 * 反转字符串，原地修改
 */
public class ReverseStrin344 {
    public static void reverseString(char[] s){
        int n  = s.length;
        for (int left=0,right=n-1;left<right;left++,right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'p','e','w','s'};
        reverseString(s);
        for (char i :s){
            System.out.print(i);
        }

    }
}
