package com.leetcode.array101;

import java.util.Arrays;

class DuplicateZeros {

    public static void main(String[] args) {
        var solution = new DuplicateZeros();

        var nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(nums);
        System.out.println(Arrays.toString(nums)); // 1,0,0,2,3,0,0,4

        var nums2 = new int[]{1, 2, 3};
        solution.duplicateZeros(nums2);
        System.out.println(Arrays.toString(nums2)); // 1,2,3
    }

    public void duplicateZeros(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == 0) {
                copy = addZero(copy, i++);
            }
        }
        System.arraycopy(copy, 0, arr, 0, arr.length);
    }

    private int[] addZero(int[] numbers, int index) {
        int size = numbers.length;
        int[] copy = new int[size];
        System.arraycopy(numbers, 0, copy, 0, index);
        System.arraycopy(numbers, index, copy, index + 1, size - 1 - index);
        return copy;
    }
}
