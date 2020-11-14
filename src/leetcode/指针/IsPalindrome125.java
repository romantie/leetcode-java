package leetcode.指针;

public class IsPalindrome125 {
    public static boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for(int i=0;i<length;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }


        int n = sgood.length();
        int left=0,right=n-1;
        while(left<right){
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))){
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }

    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.print(palindrome);

    }
}
