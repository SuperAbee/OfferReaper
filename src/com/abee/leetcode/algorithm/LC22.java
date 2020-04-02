package com.abee.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC22 {

    List<String> result = new ArrayList<>();
    Set<String> test = new HashSet<>();

    /**
     * Wrong!!!
     * And I have no idea why it doesn't work.
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }

        generate(new StringBuffer("()"), n - 1);
        return result;
    }

    public void generate(StringBuffer s, int n) {
        if (n == 0) {
            if (!test.contains(s.toString())) {
                result.add(s.toString());
                test.add(s.toString());
            }

            return;
        }

        generate(new StringBuffer("(" + s.toString() + ")"), n - 1);

        List<Integer> gap = detect(s.toString());
        for (int i = 0; i < gap.size(); i++) {
            StringBuffer st = new StringBuffer(s);
            st.insert(gap.get(i), "()");
            generate(st, n - 1);
        }
    }

    public List<Integer> detect(String s) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(s.length());
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                result.add(i + 1);
            }
        }

        return result;
    }

    public List<String> generateParenthesis1(int n) {
        if (n == 0) {
            return result;
        }

        generate1("", n, n);

        return  result;
    }

    public void generate1(String s, int left, int right) {
        if (left + right == 0) {
            result.add(s);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            generate1(s + "(", left - 1, right);
        }
        if (right > 0) {
            generate1(s + ")", left, right - 1);
        }
    }


    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        List<String> res = lc22.generateParenthesis1(4);
        System.out.println(res.toString());
    }
}
