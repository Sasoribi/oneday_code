package io.sasoribi.algorithm.binarytree;

import java.util.*;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class InorderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
    
    //#94.Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal_iterate(TreeNode root) {
        if (root == null) {
            return list;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        
        while (root != null || !stack.isEmpty() ) {
            while ( root !=null && (root = root.left) != null) {
                stack.push(root);
            }
            //EndOfLeft
            root = stack.pop();
            list.add(root.val);
            
            //move point to right child
            root = root.right;
        }
        return list;
    }
    
    // /->Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        inorderTraversal(root.left);
        
        list.add(root.val);
        
        inorderTraversal(root.right);
        
        
        return list;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
