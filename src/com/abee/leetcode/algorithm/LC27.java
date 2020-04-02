package com.abee.leetcode.algorithm;

public class LC27 {

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC27 lc27 = new LC27();
        int[] nums = {1, 1, 1, 3, 3, 5};
        System.out.println(lc27.removeElement(nums, 1));
    }
}
