package leetcode.stack;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class StackToQueue {

    /** Initialize your data structure here. */
    public StackToQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    Stack<Integer> s1;
    Stack<Integer> s2;
    private int front;
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.isEmpty()){front=x;}
        while(!s1.isEmpty()){s2.push(s1.pop());}
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int s=s1.pop();
        if (!s1.isEmpty()){
            front = s1.peek();
        }
        return s;

    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
    public static void main(String[] args) {
        StackToQueue obj = new StackToQueue();
        obj.push(5);
        obj.push(6);
        obj.push(9);

        int param_2 = obj.pop();
        int parm_5 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(parm_5);
        System.out.println(param_3);
        System.out.println(param_4);
    }

}
