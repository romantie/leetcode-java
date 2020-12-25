package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/12/25
 */
public class 二叉树链表保存35 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    class ListNode{
        int val ;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode[] listOfDepth(TreeNode tree){
        //队列保存等待被范访问的节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将当前的节点加入队列
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);

        while(!queue.isEmpty()){
            //求出此时队列里的数字个数，即队列的长度
            int size = queue.size();
            ListNode cur = dummy;

            for (int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                //指针后移一位
                cur = cur.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[]{});
    }
}
