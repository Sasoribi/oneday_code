package io.sasoribi.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {1, 6, 9, 0};
        new QuickSort().quickSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
    
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public void quickSort(int[] arr) {
        randomizedPartition(arr, 0, arr.length - 1);
    }
    
    private void randomizedPartition(int[] arr, int left, int right) {
        if (left < right) {
            int p = partitionSort(arr, left, right);
            randomizedPartition(arr, left, p - 1);
            randomizedPartition(arr, p + 1, right);
        }
    }
    
    private int partitionSort(int[] arr, int left, int right) {
        //随机选取哨兵,放到尾部
        int i = new Random().nextInt(right - left + 1) + left;
        swap(arr, i, right);
        //完成排序后获取哨兵index
        return partition(arr, left, right);
    }
    
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, left);
                left++;
            }
        }
        swap(arr, left, right);
        return left;
    }
}
