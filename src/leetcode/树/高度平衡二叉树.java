package leetcode.树;

/**
 * 判断一个数是否是一个高度平衡二叉树
 */

public class 高度平衡二叉树 {
    static class TreeNode{
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

    public static boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n4.right = n4;
        int height = height(root);
        System.out.println(height);
//        System.out.println(isBalanced(root));
    }
}
