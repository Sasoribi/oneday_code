package io.sasoribi.algorithm.search;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    //34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        search(0, nums.length - 1, nums, target, result);
        return result;
    }

    private void search(int left, int right, int[] nums, int target, int[] result) {
        //Exit
        if (left > right)
            return;

        int mid = left + (right - left >> 1);

        int ele = nums[mid];

        //hit
        if (ele == target) {
            // {min,max} -> mid 用mid索引来替换掉result的min,max,以获取边界值
            if (result[0] > mid || result[0] == -1) {
                result[0] = mid;
            }
            if (result[1] < mid) {
                result[1] = mid;
            }

            //当前索引已更新,但是左右边界仍有可能存在target
            search(left, mid - 1, nums, target, result);
            search(mid + 1, right, nums, target, result);
        }

        if (ele > target) {
            search(left, mid - 1, nums, target, result);
        }
        if (ele < target) {
            search(mid + 1, right, nums, target, result);
        }
    }
}
