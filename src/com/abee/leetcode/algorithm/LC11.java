package com.abee.leetcode.algorithm;

public class LC11 {

    public int maxArea(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int t = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, t);
            }
        }

        return max;
    }

    public int maxArea1(int[] height) {

        int head = 0;
        int tail = height.length - 1;
        int max = 0;

        while (head < tail) {
            max = Math.max((tail - head) * Math.min(height[head], height[tail]), max);
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LC11 lc11 = new LC11();
        int[] ints = {1};
        System.out.println(lc11.maxArea1(ints));
    }
}
