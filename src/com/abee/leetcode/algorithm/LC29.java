package com.abee.leetcode.algorithm;

/**
 * Time Limited Error
 */
public class LC29 {

    public int divide(int dividend, int divisor) {
        int result = 0;

        double dd = Math.abs((double) dividend);
        double ds = Math.abs((double) divisor);

        while (dd >= ds) {
            dd -= ds;
            if (result < Integer.MAX_VALUE) {
                result++;
            }
        }

        if ((dividend < 0 && divisor < 0) || ((dividend > 0) && divisor > 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        LC29 lc29 = new LC29();
        System.out.println(Integer.MIN_VALUE + " " + lc29.divide(Integer.MIN_VALUE, -1));

    }
}
