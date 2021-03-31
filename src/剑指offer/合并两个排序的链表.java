package 剑指offer;

public class 合并两个排序的链表 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while (l1.next != null && l2.next != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //cur.next = l1 != null ? l1 : l2;
        if (l1.next == null) l3.next = l2;
        if (l2.next == null) l3.next = l1;
        return l3.next;

    }
}
