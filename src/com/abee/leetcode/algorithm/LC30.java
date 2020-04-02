package com.abee.leetcode.algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class LC30 {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("asd");
        set.add("qe");

        HashSet set1 = new HashSet();
        set1.add("qe");
        set1.add("asd");

        System.out.println(set1.equals(set));
    }
}
