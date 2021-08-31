package io.sasoribi.algorithm.binarytree.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesNums {
    //#26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        
        int slow = 1;
        int fast = 1;
        while (length > fast){
            //fast-1和fast来判断,否则slow指针指的可能是前面的数据冗余,导致重复替换
            if(nums[fast-1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    
}
