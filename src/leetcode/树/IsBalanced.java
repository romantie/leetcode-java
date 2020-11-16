package leetcode.树;

public class IsBalanced {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val = val;}
        TreeNode(int val ,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }
    public boolean isBalanced(TreeNode root){
        return true;
    }
}
