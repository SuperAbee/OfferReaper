package com.abee.leetcode.algorithm;

public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        int pointer = 0;
        while (flag) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].length() < pointer + 1 ||
                        strs[i + 1].length() < pointer + 1 ||
                        (strs[i].charAt(pointer) != strs[i + 1].charAt(pointer))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append(strs[0].charAt(pointer));
                pointer++;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LC14 lc14 = new LC14();
        String[] ss = new String[0];
        ss[0] = "ac";
        ss[1] = "";
        ss[2] = "baad";
        System.out.println(lc14.longestCommonPrefix(ss));
    }
}
