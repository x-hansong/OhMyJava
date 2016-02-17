package com.easy;

import com.datastructure.ListNode;

/**
 * Created by xhans on 2016/2/17.
 */
public class RemoveNthEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iterNode = head;
        ListNode preTargetNode = head;

        //拉开距离
        for (int i = 0; i < n; i++) {
            iterNode = iterNode.next;
        }
        //边界条件：n刚好等于链表的长度,此时删去头部即可
        if (iterNode == null){
            head = head.next;
            return head;
        }
        while (iterNode.next != null){
            iterNode = iterNode.next;
            preTargetNode = preTargetNode.next;
        }

        if (preTargetNode.next != null) {
            preTargetNode.next = preTargetNode.next.next;
        }

        return head;
    }
}
