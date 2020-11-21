package leetcode.listnode;

import java.util.List;

/**
 * 2020/11/21
 * 根据题目要求，这次使用归并排序，使链表实现logn的时间复杂度
 */
public class SortList2 {
    class ListNode{
        int val ;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 自顶向下归并排序
     * @param head 头节点
     * @return 升序链表
     */
    public ListNode sortList2(ListNode head){
        return sortList2(head,null);
    }

    private ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList2(head,mid);
        ListNode list2 = sortList2(mid,tail);
        ListNode sorted = merge(list1,list2);
        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1=list1,temp2=list2;
        while(temp1!=null && temp2!=null){
            if (temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null){
            temp.next=temp1;
        }else{
            temp.next=temp2;
        }
        return dummyHead;
    }

}
