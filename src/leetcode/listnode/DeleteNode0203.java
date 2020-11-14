package leetcode.listnode;

/**
 * 2020/11/13
 * 删除一个节点无返回，原链表变为删除节点后的链表
 *
 * 要删除节点c，我们可以把节点c的val变为节点d(node.next)的val，
 * 此时可以看成节点c已经变成了节点d，改变c(node)的下一个节点为e(node.next.next)。
 */
public class DeleteNode0203 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public void deteleNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;


    }
}
