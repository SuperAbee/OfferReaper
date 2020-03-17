package com.abee.leetcode.algorithm;

public class LC7 {
    public int reverse(int x) {
        String strInt = String.valueOf(x);
        char[] charsInt = strInt.toCharArray();
        if (charsInt[0] == '-') {
            reverse(charsInt, 1, charsInt.length - 1);
        } else {
            reverse(charsInt, 0, charsInt.length - 1);
        }

        try {
            return Integer.valueOf(String.valueOf(charsInt));
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LC7 lc7 = new LC7();
        int t = (int) Math.pow(2, 31);
        //System.out.println(lc7.reverse(t));
        System.out.println(Integer.valueOf("+"));
    }
}
