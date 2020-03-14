package com.abee.leetcode.algorithm;

import java.util.HashMap;

public class LC1 {

    /**
     * Time: O(n^2)
     * Time Wasted
     */
    public int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * Time: O(n)
     * HashMap is Incredible.
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (map.containsKey(goal) && (map.get(goal) != i)){
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(goal);
                return result;
            }
        }
        return null;
    }
}
