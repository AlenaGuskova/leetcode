package com.leetcode.binarysearch.templatei;

import java.util.Arrays;

class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        var solution = new MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));
        System.out.println(solution.findMedianSortedArrays(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20}));
        stressTest(10, 20);
    }

    private static void stressTest(int range1, int range2) {
        var solution = new MedianOfTwoSortedArrays();
        while (true) {
            int n = (int) (1 + (Math.random() * range1));

            int[] nums1 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = (int) (1 + Math.random() * n);
            }
            Arrays.sort(nums1);

            int m = (int) (1 + (Math.random() * range2));
            int[] nums2 = new int[m];
            for (int i = 0; i < m; i++) {
                nums2[i] = (int) (1 + Math.random() * m);
            }
            Arrays.sort(nums2);

            System.out.printf("For n=%d and m=%d%n", nums1.length, nums2.length);
            System.out.println("array: " + Arrays.toString(nums1));
            System.out.println("array: " + Arrays.toString(nums2));
            double result1 = solution.findMedianSortedArrays(nums1, nums2);
            double result2 = solution.findMedianSortedArraysNaive(nums1, nums2);
            if (result1 - result2 < 0.001) {
                System.out.printf("OK: %s %s%n", result1, result2);
            } else {
                System.out.printf("Wrong answer: %s %s%n", result1, result2);
                return;
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int start = 0, end = n;
        int left = (n + m + 1) / 2;
        while (start <= end) {
            int mid1 = (start + end) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else
                start = mid1 + 1;
        }
        return 0.0;
    }

    public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
        int[] merged = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        return merged.length % 2 != 0
                ? merged[merged.length / 2]
                : (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
    }
}
