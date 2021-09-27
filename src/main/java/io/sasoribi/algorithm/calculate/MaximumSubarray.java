package io.sasoribi.algorithm.calculate;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class MaximumSubarray {
    //53. 最大子序和
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int current = 0;
        for (int num : nums) {
            //计算当前值和下一个值,要么合并,要么取下一个值
            current = Math.max(num, current + num);
            maxValue = Math.max(current, maxValue);
        }
        return maxValue;
    }
}
