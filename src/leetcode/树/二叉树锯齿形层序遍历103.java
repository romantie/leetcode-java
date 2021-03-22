package leetcode.树;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/12/27
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 */
public class 二叉树锯齿形层序遍历103 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        //构建一个数组保存最终的结果
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        //队列保存每一层的节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftOrder = true;
        while(!queue.isEmpty()){
            //此双端队列保存每一层的数据
            LinkedList<Integer> level = new LinkedList<>();
            int sizeQueue = queue.size();
            for (int i = 0; i<sizeQueue; i++){
                TreeNode node = queue.poll();
                //如果为true，从左开始读取，数据将全部加入尾部，反之，数据全部加入首位。
                if (isLeftOrder){
                    level.addLast(node.val);
                }else {
                    level.addFirst(node.val);
                }

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(new LinkedList<>(level));
            //每一层循环完之后，将isLeftOrder反转，使下一层的方向相反
            isLeftOrder = !isLeftOrder;
        }
        return res;

    }

    public List<List<Integer>> cengxu(TreeNode root){
        //构造一个返回集合
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //构造一个队列存放节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Boolean isLeft = true;
        while (!queue.isEmpty()){
            //构造一个双端队列存放每层的值
            LinkedList<Integer> level = new LinkedList<>();
            int queueSize = queue.size();
            for (int i = 1; i<queueSize;i++){
                TreeNode node = queue.poll();
                if (isLeft){
                    level.addLast(node.val);
                }else{
                    level.addFirst(node.val);
                }

                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            res.add(level);
            isLeft = !isLeft;
        }
        return res;
    }
}
