package io.sasoribi.algorithm.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 * <p>
 * Input: root = []
 * Output: 0
 * Example 4:
 * <p>
 * Input: root = [0]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaxDepthOfTree {
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public int iterationDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return depth;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLay = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            // 每层的节点数
            currentLay = queue.size();
            while (currentLay > 0) {
                TreeNode node = queue.poll();
                
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                currentLay--;
            }
            depth++;//当前层节点已经遍历完成
        }
        
        return depth;
    }
    
    
    //Recursive
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    //->
    
    public int maxDepthE(TreeNode root) {
        //到达叶子
        if (root == null) {
            return 0;
        }
        
        //计算左子树深度
        int left = maxDepthE(root.left);
        //计算右子树深度
        int right = maxDepthE(root.right);
        
        //最大子树深度 + 1(当前层)
        return 1 + Math.max(left, right);
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
