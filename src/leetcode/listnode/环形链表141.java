package leetcode.listnode;

/**
 * 2020/12/28 环形链表
 * 使用快慢指针解决，当链表环形的时候，快指针和慢指针回相遇
 *如果没有相遇，而是走到的空节点，则链表是环形链表
 */
public class 环形链表141 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}