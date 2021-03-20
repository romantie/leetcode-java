package leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2020/11/14
 * 链表相交，给定两个单向链表，判定是否相交
 * 使用集合判断
 */
public class 判断单向链表相交 {

    public static class ListNode{
        int val ;
        ListNode next;
        ListNode(int x){val =x;}
    }

    public ListNode getIntersextionNode(ListNode headA,ListNode headB){
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode get(ListNode headA ,ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
