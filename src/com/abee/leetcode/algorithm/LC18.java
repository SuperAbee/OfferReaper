package com.abee.leetcode.algorithm;

import java.util.*;

public class LC18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> test = new HashSet<>();

        Arrays.sort(nums);
        for (int f = 0; f < nums.length; f++) {
            for (int s = 0; s < nums.length; s++) {
                if (s == f) {
                    continue;
                }

                int head = 0;
                int tail = nums.length - 1;
                while (head < tail) {
                    if (head == f || head == s) {
                        head++;
                        continue;
                    }
                    else if (tail == f || tail == s) {
                        tail--;
                        continue;
                    } else {
                        int sum = nums[f] + nums[s] + nums[head] + nums[tail];
                        if (sum > target) {
                            tail--;
                            continue;
                        } else if (sum < target) {
                            head++;
                            continue;
                        } else {
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[f]);
                            t.add(nums[s]);
                            t.add(nums[head]);
                            t.add(nums[tail]);
                            t.sort(Integer::compareTo);
                            if (!test.contains(t)) {
                                result.add(t);
                                test.add(t);
                            }
                            head++;
                            tail--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC18 lc18 = new LC18();

        int[] test = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> res = lc18.fourSum(test, target);

        for (List<Integer> in: res) {
            System.out.println(in.toString());
        }
//        Set<List<Integer>> test = new HashSet<>();
//        List<Integer> i1 = new ArrayList<>();
//        i1.add(1);
//        i1.add(-1);
//        i1.add(2);
//        i1.add(-2);
//        List<Integer> i2 = new ArrayList<>();
//        i2.add(-1);
//        i2.add(1);
//        i2.add(-2);
//        i2.add(2);
//
//        i1.sort(Integer::compareTo);
//        i2.sort(Integer::compareTo);
//        test.add(i1);
//        test.add(i2);
//
//        System.out.println(test.size());

    }

}
