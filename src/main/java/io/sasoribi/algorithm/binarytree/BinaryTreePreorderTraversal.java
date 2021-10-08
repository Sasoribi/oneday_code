package io.sasoribi.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class BinaryTreePreorderTraversal {
    //144. 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveInvoke(root, result);
        
        return result;
    }
    
    private void recursiveInvoke(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        
        result.add(root.val);
        recursiveInvoke(root.left, result);
        recursiveInvoke(root.right, result);
    }
    
    
    // 迭代
    public List<Integer> preorderTraversal_Iterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (stack.size() > 0) {
            TreeNode parent = stack.pop();
            
            result.add(parent.val);
            
            if (parent.right != null) {
                stack.push(parent.right);
            }
            if (parent.left != null) {
                stack.push(parent.left);
            }
        }
        
        return result;
    }
}
