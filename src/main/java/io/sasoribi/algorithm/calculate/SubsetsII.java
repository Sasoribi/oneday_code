package io.sasoribi.algorithm.calculate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        ans.add(subset);
        recursive(nums, ans, subset, 0);

        return ans;

    }

    private void recursive(int[] nums, List<List<Integer>> ans, ArrayList<Integer> subset, int index) {

        // 第一次循环记录含有i=0,第二次循环不含i=0的元素;
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);

            ans.add((List<Integer>) subset.clone());
            recursive(nums, ans, subset, i + 1);
            subset.remove(subset.size() - 1);

            //跳过已经使用过的数字(排重)
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
