package com.leetcode.binarysearch.templatei;

import java.util.Arrays;

class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        var solution = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // [2]
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [4,9]
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums1Sorted = getSorted(nums1);
        int[] nums2Sorted = getSorted(nums2);

        return Arrays.stream(nums1Sorted)
                .map(v -> binarySearch(nums2Sorted, v))
                .filter(v -> v != -1)
                .map(v -> nums2Sorted[v])
                .toArray();
    }

    private int[] getSorted(int[] nums1) {
        return Arrays.stream(nums1).distinct().sorted().toArray();
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
