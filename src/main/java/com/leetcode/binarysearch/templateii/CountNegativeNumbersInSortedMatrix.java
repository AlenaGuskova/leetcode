package com.leetcode.binarysearch.templateii;

class CountNegativeNumbersInSortedMatrix {

    public static void main(String[] args) {
        var solution = new CountNegativeNumbersInSortedMatrix();
        System.out.println(8 == solution.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        System.out.println(0 == solution.countNegatives(new int[][]{{3, 2}, {2, 0}}));
        System.out.println(3 == solution.countNegatives(new int[][]{{5, 1, 0}, {-5, -5, -5}}));
        System.out.println(16 == solution.countNegatives(new int[][]{{3, -1, -3, -3, -3}, {2, -2, -3, -3, -3}, {1, -2, -3, -3, -3}, {0, -3, -3, -3, -3}}));
    }

    public int countNegatives(int[][] grid) {
        int sum = 0;
        for (int[] numbers : grid) {
            int firstNegativeNumberIndex = firstNegativeNumberIndex(numbers);
            if (firstNegativeNumberIndex != -1) {
                sum += numbers.length - firstNegativeNumberIndex;
            }
        }
        return sum;
    }

    private int firstNegativeNumberIndex(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < 0) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return numbers[left] < 0 ? left : -1;
    }
}
