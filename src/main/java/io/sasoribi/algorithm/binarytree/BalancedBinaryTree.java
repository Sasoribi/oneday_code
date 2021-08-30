package io.sasoribi.algorithm.binarytree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {
    
    //110.Balanced Binary Tree_RecursiveFuntion
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
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
    
    public boolean isBalanced_DownFirst(TreeNode root) {
        return height(root) >= 0;
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
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
}