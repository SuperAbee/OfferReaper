package com.abee.leetcode.algorithm;

public class LC4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int shorter = nums1.length;
        int longer = nums2.length;

        /**
         * nums1 should always shorter than nums2.
         * To make sure index proper.
         */
        if (shorter > longer) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempLen = shorter;
            shorter = longer;
            longer = tempLen;
        }

        int scaleMax = shorter;
        int scaleMin = 0;

        while (scaleMin <= scaleMax) {
            int shorterGuard = (scaleMax + scaleMin)/ 2;
            int longerGuard = (shorter + longer + 1) / 2 - shorterGuard;

            if (shorterGuard < scaleMax && nums1[shorterGuard] < nums2[longerGuard - 1]) {
                scaleMin = shorterGuard + 1;
            } else if (shorterGuard > scaleMin && nums1[shorterGuard - 1] > nums2[longerGuard]) {
                scaleMax = shorterGuard - 1;
            } else {
                int maxLeft;
                if (shorterGuard == 0) {
                    maxLeft = nums2[longerGuard - 1];
                } else if (longerGuard == 0) {
                    maxLeft = nums1[shorterGuard - 1];
                } else {
                    maxLeft = Math.max(nums1[shorterGuard - 1], nums2[longerGuard - 1]);
                }
                if ((shorter + longer) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (shorterGuard == shorter) {
                    minRight = nums2[longerGuard];
                } else if (longerGuard == longer) {
                    minRight = nums1[shorterGuard];
                } else {
                    minRight = Math.min(nums1[shorterGuard], nums2[longerGuard]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
    }
}
