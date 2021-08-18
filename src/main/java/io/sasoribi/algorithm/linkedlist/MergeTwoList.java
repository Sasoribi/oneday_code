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
public class MergeTwoList {
    //#21 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode flag = head;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
                continue;
            }
            
            if (l2 == null) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
                continue;
            }
            
            //l1/l2都不为空
            if (l1.val >= l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        
        return flag.next;
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