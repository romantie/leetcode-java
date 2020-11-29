package leetcode.listnode;

/**
 * 2020/11/29
 * 移除链表的第N个节点
 */
public class RemoveNthFromEnd19 {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val ,ListNode next){
            this.next = next;
            this.val = val;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode low=head;
        ListNode fast =head;
        ListNode pre = head;
        if (head.next == null){
            return null;
        }
        while(n>0){
            fast=fast.next;
            n--;
        }
        while (fast != null){
            pre = low;
            low = low.next;
            fast = fast.next;
        }
        if (low==pre) return head.next;
        pre.next = low.next;
//        low.val = low.next.val;
//        low.next = low.next.next;


        return head;
    }
}
