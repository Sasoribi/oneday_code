package io.sasoribi.algorithm.array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        
        Deque<Integer> stack = new LinkedList<>();
        
        for (int current : nums2) {
            
            if (current == nums2[0]) {
                stack.push(current);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < current) {
                map.put(stack.pop(), current);
            }
            stack.push(current);
        }
        for (Integer i : stack) {
            map.put(i, -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            
            Integer integer = map.get(nums1[i]);
            nums1[i] = integer == null ? -1 : integer;
        }
        return nums1;
    }
}
