package com.leetcode.array101;

import java.util.Arrays;

class RemoveElement {
    public static void main(String[] args) {
        var solution = new RemoveElement();

        var nums1 = new int[]{3, 2, 2, 3};
        System.out.println(solution.removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1) + " " + Arrays.equals(nums1, new int[]{2, 2, 0, 0}));

        var nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(solution.removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2) + " " + Arrays.equals(nums2, new int[]{0, 1, 3, 0, 4, 0, 0, 0}));
    }


    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int num : nums) {
            if (num != val) {
                nums[j++] = num;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        return j;
    }
}
