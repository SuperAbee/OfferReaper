package com.abee.leetcode.algorithm;

public class LC9 {
    public boolean isPalindrome(int x) {
        String strInt = String.valueOf(x);

        int start = 0;
        int end = strInt.length() - 1;
        while (start < end) {
            if (strInt.charAt(start) != strInt.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        LC9 lc9 = new LC9();
        int[] tests = {112, 33, 45, -1212, +10, 1, -1, 1331, 0, -0};
        for (int i = 0; i < tests.length; i++) {
            System.out.println(lc9.isPalindrome(tests[i]));
        }
    }
}
