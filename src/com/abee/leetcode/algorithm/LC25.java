package com.abee.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = head;
        ListNode post = null;
        int counter = 1;
        for (ListNode t = head; t != null; t = t.next, counter++) {
            if (counter == k) {
                ListNode tNext = t.next;
                Map map = reverse(pre, k);
                t = (ListNode) map.get("tail");

                if (post == null) {
                    head = (ListNode) map.get("head");
                } else {
                    post.next = (ListNode) map.get("head");
                }

                t.next = tNext;

                pre = tNext;
                post = t;

                counter = 0;
            }
        }

        return head;
    }

    public Map<String, ListNode> reverse(ListNode head, int k) {
        ArrayList<ListNode> heads = new ArrayList<>();
        for (int i = 0; head != null && i < k; head = head.next, i++) {
            heads.add(head);
        }

        for (int i = heads.size() - 1; i > 0; i--) {
            heads.get(i).next = heads.get(i - 1);
        }

        HashMap map = new HashMap(2);
        map.put("head", heads.get(heads.size() - 1));
        map.put("tail", heads.get(0));
        return map;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        LC25 lc25 = new LC25();
        lc25.reverseKGroup(n1, 2);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
