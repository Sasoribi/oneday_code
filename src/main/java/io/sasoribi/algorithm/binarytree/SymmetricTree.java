package io.sasoribi.algorithm.binarytree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 */
public class SymmetricTree {
    
    //#101.Symmetric Tree -> Iterate_Breadth-First-Search
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return false;
        
        if (root.left == null ^ root.right == null)
            return false;
        
        q.offer(root.left);
        q.offer(root.right);
        
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if (left == null && right == null)
                continue;
            
            if (left == null || right == null || left.val != right.val)
                return false;
            q.offer(left.left);
            q.offer(right.right);
            
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
    
    //Recursive
    public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null)
            return false;
        
        return recursiveTree(root.left,root.right);
    }
    
    private boolean recursiveTree(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        
        if(left == null || right == null || left.val != right.val)
            return false;
        
        return recursiveTree(left.left,right.right) && recursiveTree(left.right,right.left);
    }
    

}
