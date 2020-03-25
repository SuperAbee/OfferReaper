package com.abee.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res += nums[i];
            }
            return res;
        }

        long result = Long.MAX_VALUE / 2;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            int mid = nums[i];
            int head = i - 1;
            int tail = i + 1;

            while (head >= 0 && tail < nums.length) {
                int sum = mid + nums[head] + nums[tail];
                int diff = sum - target;
                if (Math.abs(diff) < Math.abs(result - target)) {
                    result = sum;
                }
                if (diff < 0) {
                    tail++;
                }
                if (diff > 0) {
                    head--;
                }
                if (diff == 0) {
                    result = sum;
                    break;
                }
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        int target = -1;
        LC16 lc16 = new LC16();
        System.out.println(lc16.threeSumClosest(nums, target));
    }
}
