package com.leetcode.easy.array;

import java.util.Arrays;

class SquareOfSortedArray {

    public static void main(String[] args) {
        var nums = new int[]{-4, -1, 0, 3, 10}; // 0,1,9,16,100
//        var nums = new int[]{-7, -3, 2, 3, 11}; //[4,9,9,49,121]
        System.out.println(Arrays.toString(new SquareOfSortedArray().sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        var start = 0;
        var end = nums.length - 1;
        var result = new int[nums.length];
        var i = end;

        while (start <= end) {
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                result[i--] = nums[end] * nums[end--];
            } else {
                result[i--] = nums[start] * nums[start++];
            }
        }
        return result;
    }
}
