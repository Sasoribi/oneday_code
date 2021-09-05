package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums.length == 0) {
            return ans;
        }
        List<Integer> subset = new ArrayList<>();
        recursive(nums, ans, subset, 0);
        
        return ans;
        
    }
    
    private void recursive(int[] nums, List<List<Integer>> ans, List<Integer> subset, int index) {
        
        // 第一次循环记录含有i=0,第二次循环不含i=0的元素;
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            ans.add(new ArrayList<>(subset));
            recursive(nums, ans, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
