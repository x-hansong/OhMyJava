package com.easy;

/**
 * Created by xhans on 2016/2/11.
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        } else {
            ListNode nextNode = head.next;

            //递归的思路：反转下一节点开始的链表，得到已经反转的链表，此时nextNode处于链表的最后，head跟它交换位置即可
            ListNode root = reverseList(nextNode);

            head.next = null;
            nextNode.next = head;

            return root;
        }
    }

    public ListNode reverseList1(ListNode head){
        ListNode prevNode = null;

        //逐个反转相邻节点，head保存当前节点
        while (head != null){
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }
}
