package com.leetcode.array101;

class MaxConsecutiveOnes {

    public static void main(String[] args) {
        var solution = new MaxConsecutiveOnes();

        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1})); // 3
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1})); // 2
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int start = 0;

        for (int num : nums) {
            if (num == 0) {
                start = 0;
            } else {
                start++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, start);
            }
        }
        return maxConsecutiveOnes;
    }
}
