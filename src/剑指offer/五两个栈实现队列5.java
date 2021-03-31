package 剑指offer;

import java.util.Stack;

public class 五两个栈实现队列5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void  push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
