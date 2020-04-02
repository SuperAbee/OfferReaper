package com.abee.leetcode.algorithm;

public class LC2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        ListNode preTail = tail;

        int carry = 0;

        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {

            tail.val += node1 != null ? node1.val : 0;
            tail.val += node2 != null ? node2.val : 0;
            tail.val += carry;

            carry = tail.val / 10;
            tail.val = tail.val % 10;

            ListNode temp = new ListNode(0);
            tail.next = temp;
            preTail = tail;
            tail = temp;

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        tail.val = carry;

        if (carry == 0) {
            preTail.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode n1 = new ListNode(8);
        l1.next = n1;

        ListNode l2 = new ListNode(5);

        LC2 lc2 = new LC2();
        ListNode result = lc2.addTwoNumbers(l1, l2);

        for (ListNode node = result; node != null ; node = node.next) {
            System.out.print(node.val + " ");
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}

