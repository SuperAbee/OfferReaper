package com.abee.leetcode.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC12 {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> table = new LinkedHashMap<>(7);
        table.put("M", 1000);
        table.put("CM", 900);
        table.put("D", 500);
        table.put("CD", 400);
        table.put("C", 100);
        table.put("XC", 90);
        table.put("L", 50);
        table.put("XL", 40);
        table.put("X", 10);
        table.put("IX", 9);
        table.put("V", 5);
        table.put("IV", 4);
        table.put("I", 1);
        for (String key: table.keySet()) {
            int t = num / table.get(key);

            num %= table.get(key);

            for (int i = 0; i < t; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC12 lc12 = new LC12();
        System.out.println(lc12.intToRoman(3999));
    }
}
