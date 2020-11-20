package leetcode.listnode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BasicListNode2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            val = x;
        }
    }
    public void SortCreate(){
        System.out.println("创建链表");
        Scanner sc = new Scanner(System.in);
        ListNode head;
        int [] a = new int[10];
        int c = 0;
        //将输入的值存放到数组中
        for (int num=sc.nextInt();num!=-1;num=sc.nextInt()){
            a[c++] = num;
        }
        for (int i=c;i<10;i++){
            a[i] = Integer.MIN_VALUE;
        }
        Arrays.sort(a);
        for (int i=10-c;i<10;i++){
            head = new ListNode();
            head.val = a[i];
            Insert(head,head);
        }
    }

    /**
     *
     * @param node 将要插入的数据
     * @param head 链表的头节点
     */
    public void Insert(ListNode node,ListNode head){
        ListNode p = head;
        if (p.next == null){
            node.next = p.next;
            p.next = node;
        }else{
            while(p.next.val<=node.val){
                //头节点后的数据小于将要插入的数据
                if (p.next.next != null){
                    p = p.next;
                }else{
                    node.next = p.next.next;
                    p.next.next = node;
                    break;
                }
            }
        }
    }

}
