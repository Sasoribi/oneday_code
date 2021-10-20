package io.sasoribi.algorithm.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
    
    //15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 排序数组，将重复元素排列在一起
        Arrays.sort(nums);
        
        
        for (int i = 0; i < nums.length; i++) {
            if (((i > 0) && (nums[i] == nums[i - 1]))) {
                continue;
            }
            int tp = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                //相同元素跳过||当前和 < 0
                if (((nums[j] == nums[j - 1]) && (j != i + 1)) || nums[i] + nums[j] + nums[tp] < 0) {
                    continue;
                }
                
                while (tp > j && nums[i] + nums[j] + nums[tp] > 0) {
                    tp--;
                }
                
                //此时不需要继续循环
                if (tp <= j)
                    break;
                
                if (nums[i] + nums[j] + nums[tp] == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[tp]);
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
            
        }
        return result;
    }
}
