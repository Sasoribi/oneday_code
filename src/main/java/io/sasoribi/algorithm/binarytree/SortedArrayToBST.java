package io.sasoribi.algorithm.binarytree;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(10+ ((10 - 1 ) >>> 1));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToNums(nums, 0, nums.length - 1);
    }
    
    private TreeNode arrayToNums(int[] nums, int left, int right) {
        if (right < left)
            return null;
        if (left < right) {
            // >>优先度比+号还低
            int mid = left + (right - left) >> 1;
            TreeNode tmp = new TreeNode(nums[mid]);
            tmp.left = arrayToNums(nums, left, mid - 1);
            tmp.right = arrayToNums(nums, mid + 1, right);
            return tmp;
        }
        return new TreeNode(nums[left]);
    }
}
