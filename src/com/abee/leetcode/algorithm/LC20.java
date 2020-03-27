package com.abee.leetcode.algorithm;

import java.util.HashMap;
import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put(')', ' ');
        map.put(']', ' ');
        map.put('}', ' ');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        LC20 lc20 = new LC20();

        System.out.println(lc20.isValid(s));
    }
}
