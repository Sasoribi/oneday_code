package io.sasoribi.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 */
public class SameTree {
    
    /**
     * 递归实现
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null || p==null)
            return q==p;
        if(p.val != q.val)
            return false;
        
        if(!isSameTree(p.left,q.left)){
            return false;
        }
        return isSameTree(p.right, p.right);
    }
    
    
    /**
     * 迭代解法->队列->BFS
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree_iter(TreeNode p, TreeNode q) {
        Queue<TreeNode> que_1 = new LinkedList<>();
        
        if (q == null || p == null)
            return q == p;
        
        
        que_1.offer(p);
        que_1.offer(q);
        while (!que_1.isEmpty()) {
            
            p = que_1.poll();
            q = que_1.poll();
            
            if (p == null && q == null)
                continue;
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            que_1.offer(p.left);
            que_1.offer(q.left);
            
            que_1.offer(p.right);
            que_1.offer(q.right);
            
        }
        return true;
    }
    
    static class TreeNode {
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
