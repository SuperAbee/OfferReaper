package com.abee.leetcode.algorithm;

import java.util.*;

public class LC15 {

    /**
     * 时超，这一堆 Map, List 的读取插入插入操作令人智息
     */
    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 输出结果的HashTable形式，方便检查是否重复
         * HashMap.key: 来自nums的数字
         * HashMap.value: key重复次数
         */
        HashSet<HashSet<Integer>> table = new HashSet<>();

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = numsMap.get(nums[i]) == null ? 0 : numsMap.get(nums[i]);
            numsMap.put(nums[i], t + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int goal = - (nums[i] + nums[j]);
                    if (numsMap.containsKey(goal)) {
                        HashSet<Integer> t = new HashSet<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(goal);
                        table.add(t);
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        for (Iterator<HashSet<Integer>> it = table.iterator(); it.hasNext(); ) {
            HashSet set = it.next();
            LinkedList<Integer> a = new LinkedList<>();
            for (Iterator iter = set.iterator(); iter.hasNext(); ) {
                Integer t = (Integer) iter.next();
                a.add(t);
            }

            /**
             * 解决重复的数字无法重复插入问题
             */
            if (set.size() == 1) {
                if (numsMap.get(0) < 3) {
                    continue;
                } else {
                    a.add(0);
                    a.add(0);
                }
            }
            if (set.size() == 2) {
                if (a.get(0) == -2 * a.get(1) && numsMap.get(a.get(1)) >= 2) {
                    a.add(a.get(1));
                } else if (a.get(1) == -2 * a.get(0) && numsMap.get(a.get(0)) >= 2) {
                    a.add(a.get(0));
                } else {
                    continue;
                }
            }

            result.add(a);
        }

        return result;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set1 = new HashSet<>();
//        set1.add(1);
//        set1.add(2);
//        HashSet<Integer> set2 = new HashSet<>();
//        set2.add(1);
//        set2.add(2);
//        System.out.println(set1.equals(set2));

        int[] test = {-6,-8,-9,4,-14,6,-10,7,12,13,4,9,7,14,-12,7,0,14,-1,-3,2,2,-3,11,-6,-10,-13,-13,1,-9,2,2,-2,8,-9,0,-9,-12,14,10,8,3,4,0,-6,7,14,9,6,-2,13,-15,8,-5,3,-13,-8,5,-11,0,11,6,-13,-14,-9,-15,-7,-11,10,-7,14,4,3,3,11,13,-13,11,-1,0,-6,-10,0,9,0,10,11,0,0,-14,-15,-12,-1,10,12,-2,2,-10,2,-2,-10,2,-13,1,12,5,-1,-15,1,5,-8,3,10,8};

        LC15 lc15 = new LC15();
        System.out.println(lc15.threeSum(test).toString());
    }
}
