package leetcode.树;

/**
 * 2020/12/25又是一个人过圣诞啊hh
 * 实现二叉搜索树的第k大节点,
 * 在进行此题的解答首先需要知道，二叉收索树的中序遍历为递增序列
 * 所以可以看作时求二叉搜索树的倒序第k个节点
 */
public class 二叉搜索树的第k大节点54 {
    class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int res,k;
    public int kthLargest(TreeNode root,int k){
        this.k = k ;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null) return ;
        dfs(root.right);
        if (k == 0) return ;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
