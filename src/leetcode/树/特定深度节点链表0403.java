package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/12/25
 * 本质上还是二叉树的层序遍历，但是使用链表保存每一层的数据
 */
public class 特定深度节点链表0403 {
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

        //构造一个数组保存链表的头节点
        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);

        while(!queue.isEmpty()){
            //求出此时队列里的数字个数，即队列的长度
            int size = queue.size();
            ListNode cur = dummy;

            for (int i = 0;i < size; i++){
                //弹出最前面的节点，并将其放入同一层的链表节点后
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
            //将头节点放入数组中，同时将链表的头节点置空
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[]{});
    }
}
