package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2020/12/25
 * 实现二叉树的层序遍历
 */
public class 二叉树层序遍历102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }

            }
            res.add(level);

        }
        return res;
    }


    public List<List<Integer>> level(TreeNode root){
        //构造集合存放每层的值
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //构造一个队列存放节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            //level存放每层的值
            ArrayList<Integer> level = new ArrayList<>();
            int currQueueSize = queue.size();
            for (int i =1; i<currQueueSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(level);

        }
        return res;
    }
}
