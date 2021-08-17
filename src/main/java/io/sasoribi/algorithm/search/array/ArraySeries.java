package io.sasoribi.algorithm.search.array;

/**
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，
 * 对于所有 0 <= i < n 的 i ，满足下述所有要求：
 * <p>
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 * <p>
 * 返回数组 ans 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,1]
 * 输出：[1,3,2,1,1,3,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 */
public class ArraySeries {
    //#1229
    public int[] getConcatenation(int[] nums) {
        int[] results = new int[nums.length * 2];
        for (int i = 0; i < results.length; i++) {
            if (nums.length <= i) {
                results[i] = nums[i - nums.length];
                continue;
            }
            results[i] = nums[i];
        }
        
        return results;
    }
    
    //时间为原有方法的一半
    public int[] getConcatenationRefine(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length << 1];
        for (int i = 0; i < length; i++) {
            ans[i + length]= ans[i] = nums[i];//一次赋值两个
        }
        return ans;
    }
}
