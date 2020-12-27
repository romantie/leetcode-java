package leetcode.树;

/**
 * 2020/12/27
 * 判断一个树使否为一颗平衡二叉树
 */
public class 平衡二叉树offer55 {

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

    //后序遍历+剪枝，从顶至底，判断平衡二叉树最优解
    public boolean isBalanced(TreeNode root){
        return recur(root) != -1;
    }
    private int recur(TreeNode root){
        if (root == null) return 0;
        //递归左子树
        int left = recur(root.left);
        if (left == -1) return -1;
        //递归右子树
        int right = recur(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }

    //先序遍历+判断深度（从顶自底
    public boolean isBalanced2(TreeNode root){
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
