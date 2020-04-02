package com.abee.leetcode.algorithm;

public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        for (int i = 1; i <= Math.ceil(Math.log(lists.length) / Math.log(2)); i++) {
            int nextLen = (int) Math.ceil(lists.length / Math.pow(2, i));
            int len = (int) Math.ceil(lists.length / Math.pow(2, i - 1));
            for (int j = 0; j < nextLen; j++) {
                if (j + nextLen < len) {
                    lists[j] = mergeTwoLists(lists[j], lists[j + nextLen]);
                }
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = null;
        ListNode tail =null;
        if (t1.val > t2.val) {
            result = t2;
            tail = t2;
            t2 = t2.next;
        } else {
            result = t1;
            tail = t1;
            t1 = t1.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.val > t2.val) {
                tail.next = t2;
                t2 = t2.next;
                tail = tail.next;
            } else {
                tail.next = t1;
                t1 = t1.next;
                tail = tail.next;
            }
        }

        if (t1 == null) {
            tail.next = t2;
        }
        if (t2 == null) {
            tail.next = t1;
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LC23 lc23 = new LC23();
        lc23.mergeKLists(null);
        System.out.println(Math.log(9) / Math.log(2));
    }
}
