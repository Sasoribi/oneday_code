package io.sasoribi.algorithm.linkedlist;

import java.util.Arrays;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 */
public class SplitLinkedListinParts {
    
    public static void main(String[] args) {
        ListNode next = new ListNode();
        ListNode head = next;
        for (int i = 1; i < 11; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        
        Arrays.stream(new SplitLinkedListinParts().splitListToParts(head.next, 3)).forEach(ele -> {
            while (ele != null) {
                System.out.print(ele.val);
                ele = ele.next;
            }
            System.out.println("");
        });
    }
    
    //725. 分隔链表
    public ListNode[] splitListToParts(ListNode head, int k) {
        //initial
        ListNode[] result = new ListNode[k];
        
        int count = 0;
        ListNode next = head;
        while (next != null) {
            next = next.next;
            count++;
        }
        
        //计算每part节点数
        int partCount = count / k == 0 ? 1 : count / k;
        //计算余数,拼到前方的part
        int plusPart = count % k == count ? 0 : count % k;
        
        for (int i = 0; i < result.length; i++) {
            int current = 1;
            result[i] = head;
            
            if (head != null) {
                next = head.next;
                while (next != null && current < partCount) {
                    head = next;
                    next = next.next;
                    
                    current++;
                }
                if (plusPart > 0 && next != null) {
                    head = next;
                    next = next.next;
                    plusPart--;
                }
                head.next = null;
                head = next;
            }
            
        }
        
        return result;
    }
}
