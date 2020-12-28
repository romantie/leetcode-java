package leetcode.Array;


/**
 * 2020/12/28
 * 字符串相乘，通过模拟竖式相乘的方法计算
 */
public class 字符串相乘43 {
    public static String multiply(String nums1,String nums2){
        if (nums1.equals("0") || nums2.equals("0")){
            return "0";
        }
        String ans = "0";
        int m = nums1.length(), n = nums2.length();
        for (int i = n -1;i >= 0; i--) {
            //curr存储每一位相乘的结果，add存储进位
            StringBuffer curr = new StringBuffer();
            int add = 0;
            //curr全部为0
            for (int j = n -1; j >= 0;j--){
                curr.append(0);
            }
            int y = nums2.charAt(i) - '0';
            for (int j = m-1; j >= 0; j--){
                int x = nums1.charAt(i) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0){
                curr.append(add % 10);
            }
            ans = addString2(ans,curr.reverse().toString());
        }
        return ans;
    }

    private static String addString2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //add存储进位
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0 || add != 0){
            //不够位数在前面补零
            int x = i >= 0 ? num1.charAt(i) - '0': 0;
            int y = j >= 0 ? num2.charAt(j) - '0': 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }

        ans.reverse();
        return ans.toString();
    }
}

