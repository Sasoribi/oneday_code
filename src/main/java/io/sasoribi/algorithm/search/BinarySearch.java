package io.sasoribi.algorithm.search;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch {
    // recursive implement
    public int search(int[] nums, int target) {
        return recursiveSearch(nums, 0, nums.length - 1, target);
    }
    
    private int recursiveSearch(int[] nums, int left, int right, int target) {
        // end of recursive
        if (left >= right) {
            if (nums[left] != target) {
                return -1;
            } else {
                return left;
            }
        }
        int mid = left + (right - left >>> 1);
        
        
        if (nums[mid] < target)
            return recursiveSearch(nums, mid + 1, right, target);
        if (nums[mid] > target)
            return recursiveSearch(nums, left, mid - 1, target);
        return mid;
    }
    
    public int search_iterate(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left <= right) {
            mid = left + (right - left >> 1);
            
            if (target == nums[mid])
                return left;
            
            if (target > nums[mid])
                left = mid + 1;
            
            if (target < nums[mid])
                right = mid - 1;
            
        }
        //targe is not in nums
        return -1;
    }
}
