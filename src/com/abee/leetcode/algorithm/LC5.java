package com.abee.leetcode.algorithm;

public class LC5 {
    /**
     * Center Expansion Method
     */
    public String longestPalindrome0(String s) {

        if (s.length() == 0) {
            return "";
        }

        int maxHalfLength = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() / 2; j++) {
                if (i - j >= 0 && i + j < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        if (j > maxHalfLength) {
                            maxHalfLength = j;
                            index = i;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        int maxHalfLength1 = 0;
        int gap = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j <= (s.length() + 1) / 2; j++) {
                if (i - j >= 0 && i + j - 1 < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                        if (j > maxHalfLength1) {
                            maxHalfLength1 = j;
                            gap = i;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        if (maxHalfLength * 2 + 1 > maxHalfLength1 * 2) {
            return s.substring(index - maxHalfLength, index + maxHalfLength + 1);
        } else {
            return s.substring(gap - maxHalfLength1, gap + maxHalfLength1);
        }
    }

    /**
     * The code is more clear than longestPalindrome0()
     */
    public String longestPalindrome1(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = longestPalindrome1(s, i, i);
            int len2 = longestPalindrome1(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (start - end + 1 > len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int longestPalindrome1(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /**
     * @reference: https://blog.csdn.net/HappyRocking/article/details/82622881
     */
    public String maracher(String s) {

        if (s.length() <= 1 || s == null) {
            return s;
        }

        String targetStr = "";

        s = s.replace("", "-");

        int[] radius = new int[s.length()];

        int rightEdge = 0;
        int center = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i < rightEdge) {
                /**
                 * The symmetrical point against i.
                 */
                int j = 2 * center - i;
                radius[i] = Math.min(radius[j], rightEdge - i);
            }

            while (i + radius[i] + 1 < s.length() && i - radius[i] - 1 >= 0 &&
                    s.charAt(i + radius[i] + 1) == s.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (i + radius[i] > rightEdge) {
                rightEdge = i + radius[i];
                center = i;
            }

            if (targetStr.length() < radius[i] * 2 + 1) {
                targetStr = s.substring(i - radius[i], i + radius[i]);
            }
        }
        return targetStr.replace("-", "");
    }

    public static void main(String[] args) {
        String s = "aattttaa";
        LC5 lc5 = new LC5();
        System.out.println(lc5.maracher(s));
    }
}
