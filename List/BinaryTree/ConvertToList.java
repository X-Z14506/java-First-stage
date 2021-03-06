/**
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class TreeTest02 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
    public TreeNode prev = null;
    public void convertChild(TreeNode root) {
        if (root == null) {
            return;
        }
        convertChild(root.left);
        //left 为前驱，right 为后继
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        convertChild(root.right);
    }
}
