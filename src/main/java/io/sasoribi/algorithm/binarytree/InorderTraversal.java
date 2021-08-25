package io.sasoribi.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class InorderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
    
    //#94.Binary Tree Inorder Traversal
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
