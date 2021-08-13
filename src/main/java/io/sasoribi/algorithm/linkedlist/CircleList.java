package io.sasoribi.algorithm.linkedlist;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class CircleList {
    // 链表成环 内存消耗较高
    public boolean hasCycle(ListNode head) {
        ListNode low;
        ListNode fast;
        if ((fast = low = head) == null){
            return false;
        }
        while (true){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            low = low.next;
            
            if(fast == low){
                return true;
            }
        }
    }
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}