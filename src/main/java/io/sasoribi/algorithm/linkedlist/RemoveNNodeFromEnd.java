package io.sasoribi.algorithm.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNNodeFromEnd {
    //#19 Given the head of a linked list, remove the nth node from the end of the list and return its head.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(0,head);
        ListNode slow = head = fast;
        
        int gap = 0;
        
        //haven't reach tail
        while (fast != null) {
            fast = fast.next;
            if (gap > n) {
                slow = slow.next;
            } else {
                gap++;
            }
        }
        slow.next = slow.next.next;
        return head.next;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
