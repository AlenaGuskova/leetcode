package com.leetcode.array101;

class ValidMountainArray {

    public static void main(String[] args) {
        var solution = new ValidMountainArray();

        System.out.println(!solution.validMountainArray(new int[]{2, 1}));

        System.out.println(!solution.validMountainArray(new int[]{3, 5, 5}));

        System.out.println(solution.validMountainArray(new int[]{0, 3, 2, 1}));

        System.out.println(solution.validMountainArray(new int[]{1, 3, 2}));

        System.out.println(!solution.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public boolean validMountainArray(int[] arr) {
        int peak = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] >= arr[j + 1]) {
                peak = j;
                break;
            }
        }
        for (int j = peak; j < arr.length - 1; j++) {
            if (arr[j] <= arr[j + 1]) {
                return false;
            }
        }
        return peak != 0;
    }
}
