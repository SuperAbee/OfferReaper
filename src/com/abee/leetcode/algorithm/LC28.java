package com.abee.leetcode.algorithm;

public class LC28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = calcNext(needle);
        int i = 0;
        int j = 0;
        while (haystack.length() > i && needle.length() > j) {
            if (j == -1 || needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] calcNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (s.length() - 1 > i) {
            if (j == -1 || s.charAt(j) == s.charAt(i)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }

    public static void main(String[] args) {

        LC28 lc28 = new LC28();
        String txt = "mississippi";
        String pattern = "issip";
        System.out.println(lc28.strStr(txt, pattern));
    }
}
