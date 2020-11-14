package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack225 {
    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack225() {
        q1=new LinkedList<Integer>();
        q2= new LinkedList<Integer>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
       Queue<Integer> tem = q2;
       q2 = q1;
       q1 = tem;


    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack225 obj = new MyStack225();

        obj.push(5);
        obj.push(9);
        obj.push(8);
        int param_1 = obj.pop();
        int param_4 = obj.pop();
        int param_2 = obj.top();
        boolean param_3 = obj.empty();
        System.out.println(param_1);
        System.out.println(param_4);
        System.out.println(param_2);
        System.out.println(param_3);

    }
}
