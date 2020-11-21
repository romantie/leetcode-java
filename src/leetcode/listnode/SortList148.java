package leetcode.listnode;

/**
 * 2020/11/21
 * 给定一个链表的头节点，升序返回排序后的节点
 */
public class SortList148 {
    class ListNode{
        int val ;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }

    }

    /**
     *
     * @param head 头节点
     * @return 升序的链表
     */
    public ListNode sortList(ListNode head){
        if (head.next == null || head == null){
            return head;
        }
        ListNode cur = null,tail = null;
        cur = head;
        while(cur.next != tail){
            while(cur.next != tail){
                if (cur.val > cur.next.val){
                    int temp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = temp;
                }
                cur = cur.next;
            }
            tail = cur;
            cur = head;
        }
        return head;
    }

}
