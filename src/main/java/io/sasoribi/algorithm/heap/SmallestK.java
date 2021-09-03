package io.sasoribi.algorithm.heap;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class SmallestK {
    // tips: 完全二叉树性质实现堆:子节点(Index - 1) >> 1 为父节点Index
    // 父节点(Index << 1) + 1为子节点Index
    // 大顶堆
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            // compare
            if (size < k) {
                ans[size++] = arr[i];
                if (size == 1)
                    continue;
                
                //exist element
                upBalanceHeap(ans, size);
            }
            if (size >= k) {
                // 元素比堆顶小->替换堆顶->下沉元素;
                if (ans[0] > arr[i]) {
                    ans[0] = arr[i];
                    downBalanceHeap(ans, k);
                }
            }
        }
        return ans;
    }
    
    private void downBalanceHeap(int[] ans, int size) {
        int parent = 0;
        int temp = ans[0];
        
        // down
        int half = size >>> 1;        // loop while a non-leaf -> 获取最后一个叶子的父节点Index(最差的情况的遍历终点)
        while (parent < half) {
            int child = (parent << 1) + 1; // assume left child is least
            int c = ans[child];
            int right = child + 1;
            // min(left,right)->swap
            if (right < size && ans[child] > ans[right]) {
                c = ans[right];
                child = right;
            }
            
            if (temp >= ans[right])
                break;
            ans[parent] = c;
            parent = child;
        }
        ans[parent] = temp;
        
    }
    
    //上浮->up
    private void upBalanceHeap(int[] ans, int size) {
        int current = --size;
        int parent;
        int temp = ans[current];
        while (current > 0) {
            parent = (current - 1) >>> 1;
            //end
            if (ans[parent] >= temp)
                break;
            
            ans[current] = ans[parent];
            current = parent;
        }
        ans[current] = temp;
    }
}
