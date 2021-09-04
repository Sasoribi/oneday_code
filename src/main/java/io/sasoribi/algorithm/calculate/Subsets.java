package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements,
 * return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Object> subset = new ArrayList<>();
        boolean[] statusArr = new boolean[nums.length];
        
        recursive(nums,ans,subset,statusArr);
        

        
    }
    
    private void recursive(int[] nums,List<List<Integer>> ans, List<Object> subset, boolean[] statusArr) {
    
        for (int i = 0; i < nums.length; i++) {
            subset.add(nums[i]);
            
            statusArr[i] = true;
        }
    }
}
