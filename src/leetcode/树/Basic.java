package leetcode.树;

/**
 * 树的基础知识代码，树的前序中序后序遍历，查找
 */
public class Basic {

    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1,"松江");
        HeroNode node2 = new HeroNode(2,"无用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        //先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        //测试
        binaryTree.preOrder();
        System.out.println("-------------------");
        binaryTree.midOrder();
        System.out.println("-------------------");
        binaryTree.lastOrder();

        //遍历查找
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode!=null){
            System.out.printf("找到，信息为 no=%d name=%s",resNode.getNo(),resNode.getName());
        }


    }


}
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("根节点为空不能遍历");
        }
    }
    //中序遍历
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }
    }
    //后序遍历
    public void lastOrder(){
        if (this.root != null){
            this.root.lastOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root!=null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //前序遍历查找
    public HeroNode midOrderSearch(int no){
        if (root!=null){
            return root.midOrderSearch(no);
        }else{
            return null;
        }
    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历的方法
    public void preOrder(){
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }
    //后序遍历
    public void lastOrder(){
        if (this.left != null){
            this.left.lastOrder();
        }
        if (this.right != null){
            this.right.lastOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     * @param no 查找的号码
     * @return 返回节点
     */
    public HeroNode preOrderSearch(int no){
        //比较当前的节点是不是
        if (this.no == no){
            return this;
        }
        //判断当前节点的左节点是否为空，如果不空，递归前序查找
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    public HeroNode midOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }
}