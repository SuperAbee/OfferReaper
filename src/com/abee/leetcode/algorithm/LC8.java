package com.abee.leetcode.algorithm;

public class LC8 {
    public int myAtoi(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                str = str.substring(i);
                break;
            } else {
                continue;
            }
        }

        if (str.length() == 0) {
            return 0;
        }

        char firstChar = str.charAt(0);
        if (firstChar != '-' && firstChar != '+' && !isNumber(firstChar)) {
            return 0;
        } else {
            int end = isNumber(firstChar) ? -1 : 0;
            for (int i = end + 1;
                 i < str.length(); i++, end++) {
                if (!isNumber(str.charAt(i))) {
                    break;
                }
            }
            try {
                return Integer.valueOf(str.substring(0, end + 1));
            } catch(NumberFormatException e) {
                if (end == 0) {
                    return 0;
                }
                if (firstChar == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
    }

    private Boolean isNumber(char c) {
        return (c >= 48 && c <= 57) ? true : false;
    }

    public static void main(String[] args) {
        LC8 lc8 = new LC8();
        String[] tests = new String[6];
        tests[0] = "asd"; tests[1] = ""; tests[2] = "+"; tests[3] = "   -1 1 2 a";
        tests[4] = "  -ad"; tests[5] = "123";
        for (int i = 0; i < tests.length; i++) {
            System.out.println(lc8.myAtoi(tests[i]));
        }
    }
}
