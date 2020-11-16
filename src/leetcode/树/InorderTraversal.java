package leetcode.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/11/16
 * 二叉树的中序遍历，自己写一下看能不能写出来吧
 */
public class InorderTraversal {

    //先使用递归的方法中序遍历
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root){
        res = new ArrayList<>();
        dfs(root);
        return res;

    }
    private void dfs(TreeNode root){
        if (root == null){
            return ;
        }
        //中序遍历，先遍历左子树，
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);

    }

    //再使用迭代的方法进行中序遍历
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val ,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

