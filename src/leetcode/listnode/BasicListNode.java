package leetcode.listnode;

import java.util.List;

/**
 * 链表的基础练习
 * 获取链表的第index的系欸但的数2.在链表的最前面，最后面，在链表的index前插入一个节点
 * 删除链表的index节点
 */
public class BasicListNode {
    class ListNode{
        int val ;
        ListNode next;
        ListNode(){}
        ListNode(int x ){val = x;}

    }
    //初始化链表

    public BasicListNode() {
        ListNode dummyHead = new ListNode(0);//定义一个头节点
        int size = 0;
    }

    //获得index个节点元素的值
    public int get(int index,ListNode head){
        ListNode dummyHead = head;
        if (index<0){
            return -1;
        }
        ListNode curr = dummyHead.next;
        while(curr.next!=null && index>-1){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }
    public int gettwo (int index ,ListNode head){
        ListNode dummyHead = head;
        if (index < 0){
            return -1;
        }
        ListNode curr = dummyHead.next;
        while(curr.next != null && index >-1){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }
    //在链表的最前面插入一个值
    public ListNode addAtHead(int val,ListNode head){
        ListNode dummyHead = null,curr = null;
        dummyHead.next = head;
        curr.val = val;
        curr.next = head;
        dummyHead.next = curr;
        return dummyHead;
    }
    public  ListNode add(int val ,ListNode head){
        ListNode dummyHead = null, curr = null;
        dummyHead.next = head;
        curr.val = val;
        curr.next = head;
        dummyHead.next = curr;
        return dummyHead;
    }
}
