package io.sasoribi.algorithm.binarytree;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        int sum = 0;
        return recursiveInvoke(root, targetSum, sum);
    }
    
    boolean recursiveInvoke(TreeNode root, int targetSum, int current) {
        if(root == null)
            return false;
        
        current += root.val;
        if(root.left ==null && root.right == null){
            return targetSum == current;
        }
        return recursiveInvoke(root.left, targetSum, current) || recursiveInvoke(root.right, targetSum, current);
    }
}
