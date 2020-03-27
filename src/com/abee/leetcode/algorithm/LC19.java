package com.abee.leetcode.algorithm;

import java.util.HashMap;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> backup = new HashMap<>();
        int i = 1;
        for (ListNode node = head; node != null; node = node.next, i++) {
            backup.put(i, node);
        }

        /**
         * 头指针需删除的情况
         */
        if (backup.size() == n) {
            return backup.get(1).next;
        } else {
            backup.get(backup.size() - n).next = backup.get(backup.size() - n + 1).next;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
