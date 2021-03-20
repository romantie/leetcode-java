package leetcode.listnode;

/**
 * 对链表进行插入排序，使链表有序
 */
public class 链表插入排序147 {
    class ListNode{
        int val ;
        ListNode next;
        ListNode(){}
        ListNode(int x){val = x;}
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {

                ListNode pre = dummyHead;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }

        return dummyHead.next;
    }

}
