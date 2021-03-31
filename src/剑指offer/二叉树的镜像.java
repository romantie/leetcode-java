package 剑指offer;

import java.util.Stack;

public class 二叉树的镜像 {

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public TreeNode mirTree(TreeNode root){
      if (root == null) return null;
        //将主节点压入
        Stack<TreeNode> stack = new Stack<>(){{add(root);}};
        while (!stack.isEmpty()){
            //弹出主节点
            TreeNode node  = stack.pop();
            //将节点的左右加入栈
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            //交换左右节点，
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
