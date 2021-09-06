package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        ans.add(subset);
        
        if (nums.length == 0)
            return ans;
        
        //排序,使得可以跳过重复数字 --> 重复子集
        Arrays.sort(nums);
        
        recursiveInvoke(nums, ans, subset, 0);
        
        return ans;
    }
    
    private void recursiveInvoke(int[] nums, List<List<Integer>> ans, List<Integer> subset, int current) {
        
        for (int i = current; i < nums.length; i++) {

            subset.add(nums[i]);
            ans.add(new ArrayList<>(subset));
            
            recursiveInvoke(nums, ans, subset, i + 1);
            subset.remove(subset.size() - 1);
    
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
    }
}
