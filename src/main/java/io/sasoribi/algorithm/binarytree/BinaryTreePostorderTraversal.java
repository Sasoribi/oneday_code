package io.sasoribi.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class BinaryTreePostorderTraversal {
    //145. 二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> sub = new LinkedList<>();
        
        stack.push(root);
        
        while (stack.size() > 0) {
            TreeNode mid = stack.pop();
            
            sub.push(mid);
            
            if (mid.left != null)
                stack.push(mid.left);
            if (mid.right != null)
                stack.push(mid.right);
        }
        
        while (sub.size() > 0) {
            result.add(sub.pop().val);
        }
        
        return result;
    }
    
    
    public List<Integer> postorderTraversal_recursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveInvoke(root, result);
        return result;
    }
    
    private void recursiveInvoke(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        //left->right->mid
        recursiveInvoke(root.left, result);
        recursiveInvoke(root.right, result);
        
        result.add(root.val);
    }
}
