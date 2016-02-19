package com.easy;

import com.datastructure.ListNode;

/**
 * Created by xhans on 2016/2/19.
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        //找到中间位置
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //cur指向后半段
        ListNode cur = slow.next;
        slow.next = null;

        //反转后半段
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = temp;
        }

        while (slow != null){
            if (head.val != slow.val){
                return false;
            } else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;
    }
}
