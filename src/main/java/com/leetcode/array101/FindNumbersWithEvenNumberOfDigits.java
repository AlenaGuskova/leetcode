package com.leetcode.array101;

class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        var solution = new FindNumbersWithEvenNumberOfDigits();

        System.out.println(solution.findNumbers(new int[]{555, 901, 482, 1771})); // 1
        System.out.println(solution.findNumbers(new int[]{12, 345, 2, 6, 7896})); // 2
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) count++;
        }
        return count;
    }
}
