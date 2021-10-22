package io.sasoribi.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(2), null));
        new RecoverTree().recoverTree(treeNode);
    }
    
    //99. 恢复二叉搜索树
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursiveInvoke(root, list);
        int index = -1;
        int last = -1;
        boolean tag = false;
        int cur = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            cur = list.get(i).val;
            if (cur > list.get(i + 1).val) {
                if (!tag) {
                    index = i;
                    last = i + 1;
                    tag = true;
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
