package com.leetcode.binarysearch.templateii;

class ValidPerfectSquare {

    public static void main(String[] args) {
        var solution = new ValidPerfectSquare();
        System.out.println(solution.isPerfectSquare(4));
        System.out.println(!solution.isPerfectSquare(5));
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(!solution.isPerfectSquare(14));
        System.out.println(!solution.isPerfectSquare(Integer.MAX_VALUE));
    }

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num / 2 + 2;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle < num / middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left * left == num;
    }
}
