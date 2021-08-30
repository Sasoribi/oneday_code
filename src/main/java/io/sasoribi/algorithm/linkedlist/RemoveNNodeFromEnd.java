package io.sasoribi.algorithm.linkedlist;

/**
 *     #19
 *     Given the head of a linked list,
 *     remove the nth node from the end of the list and return its head.
 */
public class RemoveNNodeFromEnd {
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

}
