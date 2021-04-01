package 剑指offer;

import java.util.Stack;

public class 两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void appendTail(int value){
        stack1.push(value);
    }

    public int dateleHead{
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
