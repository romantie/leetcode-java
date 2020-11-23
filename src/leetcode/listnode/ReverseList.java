package leetcode.listnode;

import java.util.Stack;

/**
 * 2020/11/13 lmk 反转链表练习，
 */
public class ReverseList {

    class ListNode{
        int val ;
        ListNode next;
        ListNode(){}
        ListNode(int x){val = x;}
    }
    /**
     * 使用栈解决，节点一个个入栈，出栈时将节点串成一个新的链表
     */
    public ListNode reverseList(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        //将链表全部装入栈中
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }

        ListNode node = stack.pop();
        ListNode dummy = node;
        //将节点全部出栈
        while(!stack.isEmpty()){
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个节点是反转前的头节点，让其next为空，否则会形成环
        node.next= null;
        return dummy;

    }
    /**
     * 双链表，将原链表一个个摘掉，然后在重新连接在一起
     */
    public ListNode reverseList2(ListNode head){
        //新链表
        ListNode newHead = null;
        while(head!=null){
            //保存访问节点的下一个节点
            ListNode temp = head.next;
            //每次访问将原链表的节点变为新链表的头节点，
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}
