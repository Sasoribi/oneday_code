package io.sasoribi.algorithm.binarytree;

import io.sasoribi.algorithm.linkedlist.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class RemoveLinkedListElements {
    //203. 移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode next;
        ListNode prev = dummy;
        
        while (head != null) {
            next = head.next;
            if (head.val == val) {
                prev.next = next;
                
            } else {
                prev = head;
            }
            head = next;
        }
        
        return dummy.next;
    }
}
