package com.abee.leetcode.algorithm;


public class LC24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode preTail = null;
        ListNode tail = head;

        while (tail != null && tail.next != null) {
            ListNode t = tail.next;

            tail.next = tail.next.next;
            t.next = tail;

            /**
             * First swap.
             */
            if (tail == head) {
                head = t;
            } else {
                preTail.next = t;
            }

            preTail = tail;
            tail = tail.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n4.next = null;

        LC24 lc24 = new LC24();
        ListNode node = lc24.swapPairs(n1);
        System.out.println(node.val + " " + node.next.val + " " + node.next.next.val);
    }


     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
