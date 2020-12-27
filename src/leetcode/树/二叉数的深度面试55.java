package leetcode.树;


import java.util.LinkedList;
import java.util.List;

/**
 * 2020/12/27
 * 求二叉树的深度
 */
public class 二叉数的深度面试55 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
        TreeNode(int x,TreeNode left,TreeNode right){
            val = x;
            this.left = left;
            this.right = right;
        }
    }
    //后序遍历dfs
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    //层序遍历bfs
    public int maxDepth2(TreeNode root){
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>(){{
            add(root);
        }},tmp;
        int res = 0;
        while(!queue.isEmpty()) {
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
