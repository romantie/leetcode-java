package leetcode.树;

import java.util.LinkedList;

public class 对称二叉树101 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归解法，使用两个指针分别指向树，然后一个在左边遍历，一个在右边遍历，
     * 判断节点是否相同，相同返回true
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        return check(root,root);
    }
    private boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }


    //迭代解法，使用队列，将两个指针分别入队，然后使用方法一的思路，
    public boolean isSymmetric2(TreeNode root){
        return check2(root,root);
    }
    private boolean check2(TreeNode u,TreeNode v){
        LinkedList<TreeNode> q = new LinkedList<>();
        //使用两个指针分别指向树的根节点
        q.offer(u);
        q.offer(v);
        //指针向下遍历，
        while (!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            //如果两个指针指向的节点相同则跳出此次判断，
            if (u == null && v == null){
                continue;
            }
            if (u == null || v == null || u.val != v.val){
                return false;
            }
            //分别向节点的下一个节点入队
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
