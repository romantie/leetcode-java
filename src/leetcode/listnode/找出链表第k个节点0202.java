package leetcode.listnode;

/**
 * 找出链表中的第k个节点
 * 用双指针，
 */
public class 找出链表第k个节点0202 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
    public static int kthToLast(ListNode head, int k) {
        //定义连个节点指向头节点，j和i节点相差k个元素，当j指向空节点时，i指向倒数第k个节点
        ListNode i = head;
        ListNode j = head;
        while(k-- >0){
            j = j.next;
        }
        while(j!=null){
            j = j.next;
            i = i.next;
        }
        return i.val;
    }
    public static int k(ListNode head ,int k){
        ListNode frist = head;
        ListNode  sec= head;
        while(k-- > 0){
            frist = frist.next;
        }
        while (frist != null){
            frist = frist.next;
            sec = sec.next;
        }
        return sec.val;
    }
    public static void main(String[] args) {

    }
}
