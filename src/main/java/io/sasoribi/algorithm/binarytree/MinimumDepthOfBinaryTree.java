package io.sasoribi.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {
    
    public int minDepthBFS(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        
        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode ele = q.poll();
                
                if (ele.left == null && ele.right == null)
                    return ++depth;
                
                if (ele.left != null)
                    q.offer(ele.left);
                if (ele.right != null)
                    q.offer(ele.right);
            }
            depth++;
        }
        return 0;
    }
    
    
    //DFS->Implement
    public int minDepth(TreeNode root) {
        return root == null ? 0 : minDepthRecursive(root);
    }
    
    
    public int minDepthRecursive(TreeNode root) {
        if (root == null)
            return -1;
        
        // 到达叶子
        if (root.left == null && root.right == null)
            return 1;
        
        int left = minDepthRecursive(root.left);
        int right = minDepthRecursive(root.right);
        
        if (left == -1) {
            return 1 + right;
        }
        if (right == -1) {
            return 1 + left;
        }
        
        return 1 + Math.min(left, right);
    }
    
    
}
