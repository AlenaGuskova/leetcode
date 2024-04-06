package com.leetcode.array101;

import java.util.Arrays;

class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        var solution = new RemoveDuplicatesFromSortedArray();

        var nums = new int[]{1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        var nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }

    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[pointer++] = nums[i + 1];
            }
        }
        return pointer;
    }
}