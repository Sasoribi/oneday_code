package io.sasoribi.algorithm.number;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * Example 4:
 * <p>
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * Example 5:
 * <p>
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        int max = 0;
        for (int i = candidates.length - 1; i > 0; i--) {
            if (target >= candidates[i]) {
                max = ++i;
                break;
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        
        backTracking(candidates, ans, subAns, 0, max, target, 0);
        return ans;
    }
    
    private void backTracking(int[] candidates, List<List<Integer>> ans, List<Integer> subAns, int min, int max, int target, int current) {
        for (int i = min; i < max; i++) {
            int sum = current + candidates[i];
            if (sum > target)
                return;
            if (sum == target) {
                subAns.add(candidates[i]);
                ans.add(new ArrayList<>(subAns));
                return;
            }
            
            subAns.add(candidates[i]);
            // min=i->可选自身重复
            backTracking(candidates, ans, subAns, i, max, target, sum);
            subAns.remove(subAns.size()-1);
            
        }
        
    }
}