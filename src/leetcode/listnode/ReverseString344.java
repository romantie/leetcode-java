package leetcode.listnode;

public class ReverseString344 {

    public static void ReverseString(char[] s){
        int n = s.length;
        for (int left=0,right=n-1;left<right;++left,--right){
            char tem = s[left];
            s[left] = s[right];
            s[right] = tem;
        }

    }
    public static void main(String[] args) {
        char[] s= {'s','f','w','r'};
        ReverseString(s);
        for (char i:s){
            System.out.print(i);
        }

    }
}
