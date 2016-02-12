package com.easy;

/**
 * Created by xhans on 2016/2/12.
 */
public class MergeSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode small = l1.val < l2.val ? l1 : l2;
        ListNode big = l1.val < l2.val ? l2 : l1;

        small.next = mergeTwoLists(small.next, big);

        return small;
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode tail = head;

        if (head == l1){
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }


        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            tail.next = null;
        }

        if (l1 != null){
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return head;
    }
}
