package leetcode.动态规划;

/**
 * 第五题，判断最长回文子字符串
 */
public class longestPalindrome5 {
     public static String longestPa(String s){

         int n = s.length();
         boolean[][] dp = new boolean[n][n];
         String ans= "";
         for (int l=0; l<n;++l){
             for (int i=0;i+l<n;++i){
                 int j = i+l;
                 if (l==0){
                     dp[i][j] = true;
                 }else if (l==1){
                     dp[i][j] = (s.charAt(i) ==s.charAt(j));
                 }else{
                     dp[i][j] = (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);

                 }

                 if (dp[i][j] && l+1>ans.length()){
                     ans = s.substring(i,i+l+1);
                 }
             }
         }
         
         return ans;
     }

    public static void main(String[] args) {
        String s="ababc";
        String s1 = longestPa(s);
        System.out.println(s1);
    }

}
