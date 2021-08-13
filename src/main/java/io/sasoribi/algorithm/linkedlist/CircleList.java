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
    // #141 环形链表
    public boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        
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