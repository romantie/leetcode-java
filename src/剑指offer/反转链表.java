package 剑指offer;

public class 反转链表 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    //迭代写法
    public static ListNode reverseNode(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            //将后一个节点存储
            ListNode next = curr.next;
            //当前节点指向前一个节点
            curr.next = pre;
            //前一个节点指向当前节点
            pre = curr;
            //当前节点向前移，指向next节点
            curr = next;
        }
        return pre;
    }

    //递归写法
    public ListNode reverseLis(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseLis(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

}
