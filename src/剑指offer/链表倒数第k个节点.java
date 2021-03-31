package 剑指offer;

public class 链表倒数第k个节点 {

    class ListNode{
        int val ;
        ListNode next;
        ListNode(int x){this.val = x;}
    }

    public static ListNode getKNode(ListNode head,int k){
        ListNode low = head;
        ListNode fast = head;
        while (k-- > 0){
            low = low.next;
        }
        while (low != null){
            low = low.next;
            fast = fast.next;
        }
        return fast;
    }
}
