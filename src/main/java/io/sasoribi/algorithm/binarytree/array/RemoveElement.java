package io.sasoribi.algorithm.binarytree.array;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地(In-Place) 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(new RemoveElement().removeElement(a,4));
        Arrays.stream(a).forEach(System.out::println);
    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i <= j) {
            //tail->head搜寻不为val的值
            while (nums[j] == val) {
                if (j == i)
                    break;
                j--;
            }
            if (nums[i] == val) {
                if (j <= i) {
                    return j;
                }
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return i;
    }
}
