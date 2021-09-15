package io.sasoribi.algorithm.linkedlist;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        
        //initial
        slow = fast = head;
        while (fast != null) {
            slow = slow.next;
            
            if ((fast = fast.next) == null) {
                return null;
            }
            //fast point
            fast = fast.next;
            
            
            if (fast == slow) {
                if (fast == head) {
                    return head;
                }
                return slow.next;
            }
        }
        return null;
    }
}
