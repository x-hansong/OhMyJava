package com.leecode.easy;

import com.leecode.datastructure.ListNode;

/**
 * Created by xhans on 2016/2/15.
 */
public class IntersectionLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        int minLen = Math.min(lenA, lenB);
        //对齐两个链表
        while (lenA-- > minLen){
            headA = headA.next;
        }
        while (lenB-- > minLen){
            headB = headB.next;
        }

        return sameNode(headA, headB);

    }
    private ListNode sameNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        if (headA == headB){
            return headA;
        }
        return sameNode(headA.next, headB.next);
    }

    private int len(ListNode node){
        int len = 0;
        ListNode head = node;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
