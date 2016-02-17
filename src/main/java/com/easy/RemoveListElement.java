package com.easy;

import com.datastructure.ListNode;

/**
 * Created by xhans on 2016/2/17.
 */
public class RemoveListElement {
    public ListNode removeElements(ListNode head, int val) {
        //排除前面相等的部分
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head != null) {

            ListNode iter = head;

            while (iter.next != null) {
                if (iter.next.val == val) {
                    iter.next = iter.next.next;
                } else {
                    iter = iter.next;
                }
            }
        }
        return head;
    }
}
