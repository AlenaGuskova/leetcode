package com.leetcode.binarysearch.templateii;

import java.util.Random;

class RandomPickWithWeight {

    private int sum;
    private final Random random;
    private final int[] weights;
    private final int[] prefixSums;

    public RandomPickWithWeight(int[] w) {
        weights = w;
        prefixSums = getPrefixSums();
        random = new Random();
    }

    private int[] getPrefixSums() {
        int[] prefixSums = new int[weights.length];
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            prefixSums[i] = total;
        }
        sum = total;
        return prefixSums;
    }

    public int pickIndex() {
        int randomSlice = random.nextInt(sum) + 1;
        return binarySearch(prefixSums, randomSlice);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var solution = new RandomPickWithWeight(new int[]{3, 14, 1, 7});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
