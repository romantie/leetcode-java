package 剑指offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 利用栈的特性，先进后出
 * 先将节点存入栈中，然后在将节点出栈
 */
public class 从尾到头打印链表 {

    static class ListNode{
        int val ;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public static int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++){
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        int[] ints = reversePrint(l1);
        for (int s:ints){
            System.out.println(s);
        }
        System.out.println(Arrays.toString(ints));
    }
}
