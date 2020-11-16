package leetcode.树;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 2020/11/16
 * n叉树的前序遍历
 */
public class Preorder589 {
    /**
     * 采用递归的写法，比较简单
     */
    private List<Integer> res;
    public List<Integer> preorder(Node root){
        res = new LinkedList<>();
        dfs(root);
        return res;
    }
    private void dfs(Node root){
        if (root==null){
            return ;
        }
        res.add(root.val);
        for (var child:root.childern){
            dfs(child);
        }
    }
    //用迭代的方法
    public List<Integer> preorder2(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.childern);
            for (Node item:node.childern){
                stack.add(item);
            }
        }
        return output;




    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(6);
        Node node4 = new Node(8);

    }


}
class Node{
    public int val;
    public List<Node> childern;
    public Node(){}
    public Node(int _val){
        val = _val;
    }
    public Node(int _val ,List<Node> _childern){
        val = _val;
        childern = _childern;
    }
};
