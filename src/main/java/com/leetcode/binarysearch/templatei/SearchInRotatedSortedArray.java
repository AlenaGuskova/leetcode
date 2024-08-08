package com.leetcode.binarysearch.templatei;

class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        var solution = new SearchInRotatedSortedArray();
        System.out.println(4 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(-1 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(-1 == solution.search(new int[]{1}, 0));
        System.out.println(2 == solution.search(new int[]{5, 1, 3}, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[left]) {
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
