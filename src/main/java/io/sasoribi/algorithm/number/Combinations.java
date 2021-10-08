package io.sasoribi.algorithm.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Combinations {
    //77. 组合
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        //构建数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        recursiveInvoke(nums, temp, result, 0, k);
        return result;
    }
    
    private void recursiveInvoke(int[] nums, List<Integer> temp, List<List<Integer>> result, int index, int size) {
        if (temp.size() == size) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // 此题关键剪枝
            // 剩余元素+当前标记元素 < 规定个数 + index时,后续枝的元素 <k ,所以不满足题目规定
            if(temp.size() + nums.length < size + i){
                return;
            }
            temp.add(nums[i]);
            recursiveInvoke(nums, temp, result, i + 1, size);
            //剪枝
            temp.remove(temp.size() - 1);
            
        }
    }
}
