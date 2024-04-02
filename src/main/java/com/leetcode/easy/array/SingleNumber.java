package com.leetcode.easy.array;

import java.util.Arrays;

class SingleNumber {

    public static void main(String[] args) {
        var nums = new int[]{2,2,1};
//        var nums = new int[]{8, 1, 2, 1, 2};
//        var nums = new int[]{1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .reduce(0, (a, b) -> a ^ b);
    }
}
