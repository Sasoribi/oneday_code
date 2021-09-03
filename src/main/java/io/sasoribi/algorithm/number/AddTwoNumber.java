package io.sasoribi.algorithm.number;

import io.sasoribi.algorithm.linkedlist.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 */
public class AddTwoNumber {


    //#2. Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode current = null;
        ListNode head = prev;
        int up = 0;
        boolean flag = false;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                //十进
                up = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
                flag = up > 9;

                current = new ListNode(up % 10);
                prev.next = current;
                prev = current;

                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if (l1 != null) {
                up = flag ? l1.val + 1 : l1.val;
                flag = up > 9;

                current = new ListNode(up % 10);
                prev.next = current;
                prev = current;

                l1 = l1.next;
                continue;
            }

            if (l2 != null) {
                up = flag ? l2.val + 1 : l2.val;
                flag = up > 9;

                current = new ListNode(up % 10);
                prev.next = current;
                prev = current;

                l2 = l2.next;
            }

        }
        //final 9+1 The First Number
        if (flag) {
            current = new ListNode(1);
            prev.next = current;
        }

        return head.next;
    }

}
