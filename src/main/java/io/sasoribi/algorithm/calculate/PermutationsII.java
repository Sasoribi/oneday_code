package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class PermutationsII {
    
    public List<List<Integer>> permute(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] statusArr = new boolean[nums.length];
        List<Integer> subAns = new ArrayList<>();
        
        depthFirstSearch(nums, subAns, statusArr, ans);
        return ans;
    }
    
    //回溯
    private void depthFirstSearch(int[] nums,
                                  List<Integer> subAns, boolean[] statusArr, List<List<Integer>> ans) {
        //状态数组->剪枝,当前位置已经确定->剪枝
        
        // 得出一个全排列列表
        if (subAns.size() == nums.length) {
            ans.add(new ArrayList<>(subAns));
            return;
        }
        
        //遍历全排列数组
        for (int i = 0; i < nums.length; i++) {
            if (!statusArr[i]) {
                // 定元素
                subAns.add(nums[i]);
                // 封枝
                statusArr[i] = true;
                
                depthFirstSearch(nums, subAns, statusArr, ans);
                
                // 状态数组回溯
                statusArr[i] = false;
                
                //弹出当前元素
                subAns.remove(subAns.size() - 1);
                
                // 跳过已经使用过的数字
                while (i < nums.length - 1 && (nums[i] == nums[i + 1])) {
                    i++;
                }
            }
        }
    }
}
    
