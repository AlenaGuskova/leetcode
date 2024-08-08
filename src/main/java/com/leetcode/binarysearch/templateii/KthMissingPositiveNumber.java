package com.leetcode.binarysearch.templateii;

import java.util.Arrays;
import java.util.stream.IntStream;

class KthMissingPositiveNumber {

    public static void main(String[] args) {
        var solution = new KthMissingPositiveNumber();
        System.out.println(9 == solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(6 == solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
        System.out.println(14 == solution.findKthPositive(new int[]{5, 6, 7, 8, 9}, 9));
        System.out.println(1 == solution.findKthPositive(new int[]{2}, 1));
        System.out.println(2 == solution.findKthPositive(new int[]{1, 3, 4, 6, 7}, 1));
    }

    private int naiveFindKthPositive(int[] array, int k) {
        int n = array.length;
        if (array[n - 1] - n == 0) {
            return k + n;
        } else {
            return k - (int) IntStream.rangeClosed(1, array[n - 1])
                    .filter(value -> Arrays.binarySearch(array, value) < 0)
                    .count()
                    + array[n - 1];
        }
    }

    public int findKthPositive(int[] array, int k) {
        int result, n = array.length;
        if (array[n - 1] - n == 0) {
            result = k + n;
        } else {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] - 1 - mid < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            result = left + k;
        }
        return result;
    }
}