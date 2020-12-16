package leetcode.Array;

/**
 * 字符串相加415，给出两个字符串，返回他们相加后的值
 * 使用指针解决
 */
public class 字符串相加415 {
    public static String addString(String num1,String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
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

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "99";
        String s = addString(num1, num2);
        System.out.println(s);
    }
}
