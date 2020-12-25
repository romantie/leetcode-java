package leetcode.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020/12/25递增顺序查找树
 * 给定义的树，按中序遍历重新排列树
 */
public class 递增顺序查找树897 {
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

        public TreeNode increaseingBST(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inorder(root,vals);
            TreeNode ans = new TreeNode(0), cur = ans;
            for (int v:vals){
                cur.right = new TreeNode(v);
                cur = cur.right;
            }
            return ans.right;
        }

        public void inorder(TreeNode node, List<Integer> vals){
            if (node == null) return ;
            inorder(node.left,vals);
            vals.add(node.val);
            inorder(node.right,vals);
        }
    }
}
