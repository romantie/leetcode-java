package leetcode.树;

import java.util.ArrayList;
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
    }
}
