package io.sasoribi.algorithm.calculate;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 */
public class FindPeakElement {
    
    //162. 寻找峰值
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        return recursiveInvoke(nums, 0, nums.length - 1);
    }
    
    private int recursiveInvoke(int[] nums, int left, int right) {
        //边界情况无峰值时,返回-1
        if (left > right) {
            return left;
        }
        
        //取值方式为总是取左边的数
        int mid = left + (right - left >> 1);
        
        //到达左边界[mid,right]
        if (mid == left) {
            if (mid == nums.length -1 &&  nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (mid == 0 &&  nums[mid] > nums[mid + 1]) {
                return mid;
            }
        }
        
        //普通寻找[mid-1,mid+1]---由于总是取左边,需要对左边界做判断(mid - 1 >= 0)
        if (mid >= 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        
        return Math.max(recursiveInvoke(nums, left, mid - 1),
                recursiveInvoke(nums, mid + 1, right));
        
    }
}
