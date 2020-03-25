package com.abee.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 0 ||digits == null) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            List<String> result = new ArrayList<>();
            String s = map.get(digits.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                char[] cs = new char[digits.length()];
                cs[0] = s.charAt(i);
                result.add(new String(cs));
            }
            return result;
        }

        List<String> result = new ArrayList<>();
        String s = map.get(digits.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char[] cs = new char[digits.length()];
            cs[0] = s.charAt(i);
            add(result, digits, digits.length() - 1, map, cs);
        }

        return result;
    }

    public void add(List<String> result, String digit, int p, Map<Character, String> map, char[] cs) {
        if (p == 0) {
            return;
        }

        int hLen = digit.length() - p;
        if (p == 1) {
            String s = map.get(digit.charAt(hLen));
            for (int i = 0; i < s.length(); i++) {
                char[] t = new char[digit.length()];
                System.arraycopy(cs, 0, t, 0, hLen);
                t[hLen] = s.charAt(i);
                result.add(new String(t));
            }
            return;
        }

        String s = map.get(digit.charAt(hLen));
        for (int i = 0; i < s.length(); i++) {
            cs[hLen] = s.charAt(i);
            add(result, digit, p - 1, map, cs);
        }
    }

    public static void main(String[] args) {
        LC17 lc17 = new LC17();
        List<String> ls = lc17.letterCombinations("234");
        for (String s:
             ls) {
            System.out.print(s + " ");
        }
    }
}
