package io.sasoribi.algorithm.number;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        
        backTracing(candidates, ans, subset, 0, target, 0);
        
        return ans;
    }
    
    private void backTracing(int[] candidates, List<List<Integer>> ans,
                             ArrayList<Integer> subset, int current, int target, int sum) {
        for (int i = current; i < candidates.length; i++) {
            sum += candidates[i];
            subset.add(candidates[i]);
            
            if (sum >= target) {
                if (sum == target) {
                    ans.add(new ArrayList<>(subset));
                }
                subset.remove(subset.size() - 1);
                break;
            }
            
            // sum < target -> keep backtracing
            backTracing(candidates, ans, subset, i + 1, target, sum);
            
            //删除当前指向的元素
            sum-=candidates[i];
            subset.remove(subset.size()-1);
            
            while (i < candidates.length -1 && candidates[i] == candidates[i + 1]){
                i++;
            }
        }
        
    }
}
