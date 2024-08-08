package com.leetcode.binarysearch.templateii;

class ArrangingCoins {

    public static void main(String[] args) {
        var solution = new ArrangingCoins();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
        System.out.println(solution.arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) (mid + 1) * mid < (long) 2 * n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left + 1) * left <= 2 * n ? left : left - 1;
    }
}
