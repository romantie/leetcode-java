package leetcode.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树后序遍历145 {
    class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        //递归实现后序遍历
        private List<Integer> res;
        public List<Integer> postorderTraversal(TreeNode root){
            res = new ArrayList<>();
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root){
            if (root == null){
                return ;
            }
            //后序遍历
            dfs(root.left);
            dfs(root.right);
            res.add(root.val);
        }

        //迭代实现二叉树的后序遍历
        public List<Integer> postorderTraversal2(TreeNode root){
            List<Integer> res = new ArrayList<Integer>();
            if (root == null){
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right==prev){
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else{
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
}
