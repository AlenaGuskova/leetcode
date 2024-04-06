package com.leetcode.array101;

import java.util.Arrays;

class SortArrayByParity {

    public static void main(String[] args) {
        var solution = new SortArrayByParity();

        var nums1 = solution.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(Arrays.toString(nums1) + " " + Arrays.equals(nums1, new int[]{2, 4, 3, 1}));
    }

    public int[] sortArrayByParity(int[] nums) {
        int j = 0;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                result[j++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 != 0) {
                result[j++] = num;
            }
        }
        return result;
    }
}
