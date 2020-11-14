package leetcode.stack;

import java.util.Stack;

/**
 * 括号匹配，力扣20题
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class KuoHao20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c:s.toCharArray()){
            if (c=='(') stack.push(')');
            else if (c=='{') stack.push('}');
            else if (c=='[') stack.push(']');
            else if (stack.isEmpty() || c!=stack.pop()) return false;
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        String s = "{[((00))}]";
        boolean b = isValid(s);
        System.out.println(b);
    }
}
