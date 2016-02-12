package com.easy;

/**
 * Created by xhans on 2016/2/12.
 */
public class OddEvenList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode  head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        while (evenNode != null && evenNode.next != null){
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }


}
