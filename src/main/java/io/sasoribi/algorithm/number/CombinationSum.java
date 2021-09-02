package io.sasoribi.algorithm.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        int max = 0;
        for (int i = candidates.length - 1; i >= 0; i--) {
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
            
            subAns.add(candidates[i]);
            if (sum == target) {
                
                ans.add(new ArrayList<>(subAns));
                subAns.remove(subAns.size() - 1);
                return;
            }
            
            // min=i->可选自身重复
            backTracking(candidates, ans, subAns, i, max, target, sum);
            subAns.remove(subAns.size() - 1);
            
        }
        
    }
}