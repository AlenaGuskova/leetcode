package com.leetcode.binarysearch;

import java.util.Arrays;

class RussianDollEnvelopes {

    public static void main(String[] args) {
        var solution = new RussianDollEnvelopes();
        System.out.println(3 == solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(2 == solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 2}, {2, 2}}));
        System.out.println(2 == solution.maxEnvelopes(new int[][]{{1, 6}, {5, 5}, {7, 12}, {8, 12}}));
        System.out.println(4 == solution.maxEnvelopes(new int[][]{{2, 22}, {5, 18}, {7, 7}, {26, 54}, {30, 64}, {60, 105}, {66, 25}, {77, 105}, {83, 48}, {92, 28}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int result = 0;
        int[] dp = new int[envelopes.length];
        for (int[] envelope : envelopes) {
            int index = binarySearch(dp, 0, result, envelope[1]);
            dp[index] = envelope[1];
            if (index == result) {
                result++;
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int index = Arrays.binarySearch(nums, left, right, target);
        return index < 0 ? (-index - 1) : index;
    }
}
