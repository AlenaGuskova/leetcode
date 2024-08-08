package com.leetcode.binarysearch.templateii;

class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        var solution = new FindMinimumInRotatedSortedArrayII();
        System.out.println(1 == solution.findMin(new int[]{1, 3, 5})); // 1
        System.out.println(0 == solution.findMin(new int[]{2, 2, 2, 0, 1})); // 0
        System.out.println(1 == solution.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(0 == solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(11 == solution.findMin(new int[]{11, 13, 15, 17})); // 11
        System.out.println(1 == solution.findMin(new int[]{1})); // 1
        System.out.println(1 == solution.findMin(new int[]{2, 1})); // 1
        System.out.println(1 == solution.findMin(new int[]{2, 3, 4, 5, 1})); // 1
        System.out.println(1 == solution.findMin(new int[]{3, 3, 1, 3})); // 1
        System.out.println(1 == solution.findMin(new int[]{1, 3, 3})); // 1
        System.out.println(1 == solution.findMin(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3})); // 1

    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
