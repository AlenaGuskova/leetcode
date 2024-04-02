package com.leetcode.easy.array;

import java.util.Arrays;

class MoveZeroes {

    public static void main(String[] args) {
//        var nums = new int[]{0, 1, 0, 3, 12};
//        var nums = new int[]{0};
        var nums = new int[]{1, 2, 3};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
