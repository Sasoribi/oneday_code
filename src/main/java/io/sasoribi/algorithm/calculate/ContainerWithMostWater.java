package io.sasoribi.algorithm.calculate;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 */
public class ContainerWithMostWater {
    //11. 盛最多水的容器
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int max = (right - left) * Math.min(height[left],height[right]);
        int current = max;
        
        while (left < right) {
            if (height[left] >= height[right]) {
                if (height[right] < height[--right]) {
                    current = (right - left) * Math.min(height[left],height[right]);
                    max = Math.max(max, current);
                }
            }else{
                if (height[left] < height[++left]) {
                    current = (right - left) * Math.min(height[left],height[right]);
                    max = Math.max(max, current);
                }
            }
        }
        return max;
    }
    
    
    
    
    
    
    
}
