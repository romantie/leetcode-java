package leetcode.树;

/**
 * 判断一个数是否是一个高度平衡二叉树
 */

public class 高度平衡二叉树 {
    class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val , TreeNode left ,TreeNode right){
            this.val = val ;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight=rightHeight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }

}
