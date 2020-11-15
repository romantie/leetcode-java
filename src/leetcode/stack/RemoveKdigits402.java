package leetcode.stack;

import java.util.Stack;

/**
 * 2020/11/15
 * 移除掉k位数字，使用栈解决
 */
public class RemoveKdigits402 {
    public static String removeKDigits(String num ,int k){
        if (num.length()==k){
            return "0";
        }
        char[] s = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character i:s){
            while (!stack.isEmpty() && i<stack.peek() && k>0){
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && i=='0'){
                continue;
            }
            stack.push(i);
        }
        while(k>0){
            stack.pop();
            k--;
        }

        //按照上面的逻辑，在最后为0的时候会直接跳过，所以在最后为空时返回0（比如10）
        if (stack.isEmpty()){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        String str = "10200";
        String res = removeKDigits(str,1);
        System.out.println(res);
    }
}
