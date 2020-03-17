package com.abee.leetcode.algorithm;

public class LC6 {
    public String convert(String s, int numRows) {

        if (numRows == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        int counter = 0;
        int gap = 2 * numRows - 2;
        char[] result = new char[s.length()];
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j+=gap) {
                result[counter++] = s.charAt(j);
                if (i != numRows - 1 && i != 0 && j + gap - 2 * i < s.length()) {
                    result[counter++] = s.charAt(j + gap - 2 * i);
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmn";
        LC6 lc6 = new LC6();
        System.out.println(lc6.convert(s, 2));
    }
}
