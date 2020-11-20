package leetcode.listnode;

/**
 * 2020/11/20每日日一题撒，又是指针，在leetcode147
 *对链表进行插入排序
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head){
        if (head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head,curr = head.next;
        while(curr != null){
            if (lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummyHead;
                while(pre.next.val <= curr.val){
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next  = curr;
            }
            curr = lastSorted.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
