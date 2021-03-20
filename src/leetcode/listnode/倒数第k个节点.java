package leetcode.listnode;

/**
 * 2020/11/13
 *与上一个的区别的，这题输出的是倒数第k个节点的的链表，
 * 重新在来写一次
 */
public class 倒数第k个节点 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val =x; }
    }

    public ListNode getKthToLast(ListNode head,int k){
        ListNode frist = head;
        ListNode sec = head;
        while (k-- > 0){
            frist=frist.next;
        }
        while (frist!= null){
            frist = frist.next;
            sec = sec.next;
        }
        return sec;
    }

    public ListNode getLast (ListNode head,int k){
        ListNode frist = head;
        ListNode sec = head;
        while (k-- > 0){
            frist = frist.next;
        }
        while(frist != null){
            frist = frist.next;
            sec = sec.next;
        }
        return sec;
    }

}
