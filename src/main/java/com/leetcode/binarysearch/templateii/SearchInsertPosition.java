package com.leetcode.binarysearch.templateii;

class SearchInsertPosition {

    public static void main(String[] args) {
        var solution = new SearchInsertPosition();
        System.out.println(2 == solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(1 == solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(4 == solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(1 == solution.searchInsert(new int[]{1}, 7));
        System.out.println(1 == solution.searchInsert(new int[]{1, 3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
