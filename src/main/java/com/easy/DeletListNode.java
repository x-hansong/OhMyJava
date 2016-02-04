package com.easy;

/**
 * Created by xhans on 2016/2/4.
 */
public class DeletListNode {
    public void deleteNode(ListNode node){
        ListNode nextNode = node.next;
        ListNode next2Node = nextNode.next;
        node.val = nextNode.val;
        node.next = next2Node;
    }

     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
}
