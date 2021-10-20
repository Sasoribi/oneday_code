package io.sasoribi.algorithm.binarytree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
    
    //110.Balanced Binary Tree_RecursiveFuntion-自顶向下
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            //左右子树高度差不大于1 && 递归搜索左子树 && 右子树
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        return Math.max(maxDepth(left), maxDepth(right)) + 1;
    }
    
    // Tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // -1 用于标志不是平衡树,终止递归
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            //高度+1
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
}