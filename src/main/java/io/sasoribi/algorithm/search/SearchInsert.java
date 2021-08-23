package io.sasoribi.algorithm.search;

import java.util.Arrays;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not,
 * return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 * <p>
 * Input: nums = [1], target = 0
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsert {
    
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,4,6,7,8,9},6));
    }
    //#35
    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1])
            return nums.length;
        if(target <= nums[0])
            return 0;
        
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while(left <= right){
            mid =  left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        
        if(target > nums[mid]){
            return mid + 1;
        }
        return mid;
    }
}
