package io.sasoribi.algorithm.linkedlist;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class RemoveDuplicatesFromSortedList {
    
    //83. 删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        
        ListNode next = head;
        ListNode curruent = next;
        while (next != null) {
            next = next.next;
            
            //next == next.next 跳过
            if (next != null) {
                if (next.val != curruent.val) {
                    curruent.next = next;
                    curruent = next;
                    continue;
                }
            }
            curruent.next = next;
        }
        return head;
    }
}
