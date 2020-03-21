package com.abee.leetcode.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC13 {

    public int romanToInt(String s) {
        Map<String, Integer> table = new LinkedHashMap<>();
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

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'M' || chars[i] == 'D' || chars[i] == 'L' || chars[i] == 'V') {
                result += table.get(String.valueOf(chars[i]));
                continue;
            }
            if (i + 1 < s.length() && table.get(s.substring(i, i + 2)) != null) {
                result += table.get(s.substring(i, i + 2));
                i++;
                continue;
            }

            result += table.get(String.valueOf(chars[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        LC13 lc13 = new LC13();
        System.out.println(lc13.romanToInt("MCMXCIV"));
    }
}
