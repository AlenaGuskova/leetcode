package com.leetcode.binarysearch.templateii;

import java.util.Arrays;

class NumberOfSubsequencesThatSatisfyGivenSumCondition {

    public static void main(String[] args) {
        var solution = new NumberOfSubsequencesThatSatisfyGivenSumCondition();
        System.out.println(4 == solution.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(6 == solution.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(1 == solution.numSubseq(new int[]{2, 1}, 2));
        System.out.println(0 == solution.numSubseq(new int[]{2, 2}, 3));
        System.out.println(61 == solution.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(49 == solution.numSubseq(new int[]{8, 9, 1, 1, 9, 4, 9, 8, 8}, 9));

        System.out.println(127 == solution.numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16));
        System.out.println(272187084 == solution.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
        System.out.println(1 == solution.numSubseq(new int[]{1}, 12));

        stressTest(10, 20);
    }

    private static void stressTest(int range1, int range2) {
        var solution = new NumberOfSubsequencesThatSatisfyGivenSumCondition();
        while (true) {
            int arrLength = (int) (1 + (Math.random() * range1));
            int k = (int) (1 + Math.random() * range2);

            int[] array = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                array[i] = (int) (1 + Math.random() * arrLength);
            }
            System.out.printf("For arrLength=%d and k=%d: ", array.length, k);
            System.out.println("array: " + Arrays.toString(array));
            int result1 = solution.numSubseq(array, k);
            int result2 = solution.numSubseqWithPointers(array, k);
            if (result1 == result2) {
                System.out.printf("OK: %d %d%n", result1, result2);
            } else {
                System.out.printf("Wrong answer: %d %d%n", result1, result2);
                return;
            }
        }
    }

    private int numSubseqWithPointers(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, r = nums.length - 1;
        int modulo = 1_000_000_007;

        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % modulo;
        }

        for (int i = 0; i < nums.length; i++) {
            while (i <= r && nums[r] + nums[i] > target) {
                r--;
            }
            if (i <= r) {
                res = (res % modulo + power[r - i]) % modulo;
            }
        }
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0, modulo = 1_000_000_007;

        int n = nums.length;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % modulo;
        }

        for (int min = 0; min < nums.length - 1; min++) {
            var max = searchInsert(nums, target - nums[min]);
            if (max >= min) {
                count = (count % modulo + power[max - min]) % modulo;
            }
        }
        return count;
    }

    private int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
