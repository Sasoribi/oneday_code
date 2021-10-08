package io.sasoribi.algorithm.linkedlist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {
    //24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        
        ListNode newHead = new ListNode();
        
        ListNode next;
        ListNode pre = newHead;
        while (head != null) {
            next = head.next;
            if (next == null) {
                pre.next = head;
                break;
            }
            pre.next = next;
            
            ListNode tempNext = next.next;
            head.next = tempNext;
            next.next = head;
            
            
            pre = head;
            head = tempNext;
        }
        return newHead.next;
    }
    
}
