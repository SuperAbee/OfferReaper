package com.abee.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

public class LC3 {

    /**
     * Time: O(n^3)
     * String.contains(): n
     * Outer nested loop: n^2
     */
    public int lengthOfLongestSubstring0(String s) {
        /**
         * possible index
         */
        Boolean[] start = new Boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            start[i] = true;
        }

        int maxLength = 0;

        for (int i = 1; i <= s.length(); i++) {

            Boolean flag = false;

            for (int j = 0; j <= s.length() - i; j++) {

                if (start[j]) {
                    String next = s.substring(j + i - 1, j + i);
                    if (s.substring(j, j + i - 1).contains(next)) {
                        start[j] = false;
                    } else {
                        flag = true;
                    }
                }
            }

            if (flag) {
                maxLength++;
            } else {
                return maxLength;
            }
        }

        return maxLength;
    }

    /**
     * Time: O(n)
     * Slide Window
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        Set<Character> window = new HashSet<>();
        int head = 0, tail = 0;
        while (head < s.length() && tail < s.length()) {
            if (window.contains(s.charAt(tail))) {
                window.remove(s.charAt(head++));
            } else {
                window.add(s.charAt(tail++));
                maxLength = Math.max(maxLength, tail - head);
            }
        }
        return maxLength;
    }



    public static void main(String[] args) {
        LC3 lc3 = new LC3();
        int result = lc3.lengthOfLongestSubstring1("pwwkew");
        System.out.println(result);
    }
}