package io.sasoribi.algorithm.array;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length + nums2.length;
        
        //奇/偶数
        boolean odd = i % 2 == 0;
        
        int left1 = 0;
        int right1 = nums1.length - 1;
        int nums1mid = 0;
        
        int left2 = 0;
        int right2 = nums2.length - 1;
        int nums2mid = 0;
        while (true) {
            if (left1 < right1) {
                nums1mid = left1 + (right1 - left1 >>> 1);
            }
            
            if (left2 < right2) {
                nums2mid = left2 + (right2 - left2 >>> 1);
            }
    
            int mid1 = nums1[nums1mid];
            int mid2 = nums2[nums2mid];
    
    
        }
        
        
    }
}
