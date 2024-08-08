package com.leetcode.binarysearch.templatei;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/description/">...</a>
 */
public class SearchIn2DMatrixII {

    public static void main(String[] args) {
        var solution = new SearchIn2DMatrixII();
        System.out.println(solution.searchMatrix(new int[][]{{2, 5}, {2, 8}, {7, 9}, {7, 11}, {9, 11}}, 7));
        System.out.println(solution.searchMatrix(new int[][]{{1, 2, 3, 7, 8}, {5, 10, 14, 16, 19}, {8, 10, 18, 19, 23}, {9, 12, 22, 24, 29}}, 14));
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}}, 13));
        System.out.println(solution.searchMatrix(new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}}, 8));
        System.out.println(solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(solution.searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, 19));
        System.out.println(solution.searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, 15));
        System.out.println(solution.searchMatrix(new int[][]{{1, 1}}, 1));
        System.out.println(solution.searchMatrix(new int[][]{{-1, 3}}, 3));
        System.out.println(solution.searchMatrix(new int[][]{{5}, {6}}, 6));
        System.out.println(solution.searchMatrix(new int[][]{{1, 4}, {2, 5}}, 2));
        System.out.println(!solution.searchMatrix(new int[][]{{1, 1}}, 2));
        System.out.println(!solution.searchMatrix(new int[][]{{1}}, 0));
        System.out.println(!solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }

//    public boolean searchMatrix(int[][] matrix, int target) { // O(n+m)
//        int row = 0, column = matrix[0].length - 1;
//        while (row < matrix.length && column >= 0) {
//            if (matrix[row][column] == target) {
//                return true;
//            } else if (matrix[row][column] > target) {
//                column--;
//            } else {
//                row++;
//            }
//        }
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) { // O(m*log(n))
        for (int[] ints : matrix) {
            int left = 0;
            int right = ints.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ints[mid] == target) {
                    return true;
                }
                if (target > ints[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
