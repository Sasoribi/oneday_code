package io.sasoribi.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), null);
        new RecoverTree().recoverTree(treeNode);
    }
    
    //99. 恢复二叉搜索树
    public void recoverTree(TreeNode root) {
        TreeNode[] treeNodes = new TreeNode[2];
        recursiveInvoke(root, treeNodes, null);
        swap(treeNodes[0], treeNodes[1]);
    }
    
    //返回值为前驱节点
    private TreeNode recursiveInvoke(TreeNode root, TreeNode[] treeNodes, TreeNode prev) {
        if (root == null)
            return null;
        
        
        if (root.left != null) {
            prev = recursiveInvoke(root.left, treeNodes, prev);
        }
        
        //handle
        if (prev != null && prev.val > root.val) {
            if (treeNodes[0] == null) {
                treeNodes[0] = prev;
                treeNodes[1] = root;
            } else {
                treeNodes[1] = root;
            }
        }
        prev = root;
        if (root.right != null) {
            
            prev = recursiveInvoke(root.right, treeNodes, prev);
        }
        
        
        return prev;
    }
    
    //空间O(n),不是最优
    public void recoverTree_bad(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursiveInvoke(root, list);
        int index = -1;
        int last = -1;
        int cur = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            cur = list.get(i).val;
            if (cur > list.get(i + 1).val) {
                if (index == -1) {
                    index = i;
                    //需要初始化last,因为可能直接进行交换,eg.[1,3,2,4]只会进行一次交换
                    last = i + 1;
                    continue;
                }
                last = i + 1;
                break;
            }
        }
        swap(list.get(last), list.get(index));
    }
    
    private TreeNode recursiveInvoke(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return null;
        
        if (root.left != null) {
            recursiveInvoke(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            recursiveInvoke(root.right, list);
        }
        
        return root;
    }
    
    private TreeNode swap(TreeNode root, TreeNode node) {
        int val = root.val;
        root.val = node.val;
        node.val = val;
        
        return root;
    }
    
}
