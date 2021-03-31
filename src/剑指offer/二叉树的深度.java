package 剑指offer;

import java.util.LinkedList;
import java.util.List;

public class 二叉树的深度 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }
    //后序遍历的揭解法
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static int maxDepth2(TreeNode root){
        if (root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> tmp;
        queue.offer(root);

        while(!queue.isEmpty()){
            tmp = new LinkedList<>();
            for (TreeNode node : queue){
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
