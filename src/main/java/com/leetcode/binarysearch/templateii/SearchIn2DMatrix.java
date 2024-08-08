package com.leetcode.binarysearch.templateii;

import java.util.Arrays;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        var solution = new SearchIn2DMatrix();
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(!solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println(!solution.searchMatrix(new int[][]{{1}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearch(getRowsByColumn(matrix), target);
        boolean result = false;
        if (row >= 0) {
            int column = binarySearch(matrix[row], target);
            if (column >= 0) {
                result = matrix[row][column] == target;
            }
        }
        return result;
    }

    private int[] getRowsByColumn(int[][] matrix) {
        return Arrays.stream(matrix)
                .mapToInt(ints -> ints[0])
                .toArray();
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] <= target ? left : left - 1;
    }
}
