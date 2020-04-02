package com.abee.leetcode.algorithm;

public class LC26 {

    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length;) {
            int first = nums[i];
            int j = 0;
            for (; j < nums.length - i; j++) {
                if (nums[i] != nums[i + j]) {
                    break;
                }
            }

            nums[result] = nums[i];
            result++;
            i += j;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 4, 5, 5, 5, 5};
        LC26 lc26 = new LC26();
        System.out.println(lc26.removeDuplicates(nums));
    }
}
