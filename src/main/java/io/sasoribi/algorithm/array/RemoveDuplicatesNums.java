package io.sasoribi.algorithm.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesNums {
    //#26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
    
}
