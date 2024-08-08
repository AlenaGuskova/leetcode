package com.leetcode.binarysearch.templateiii;

class FindPeakElement {

    public static void main(String[] args) {
        var solution = new FindPeakElement();
        System.out.println(0 == solution.findPeakElement(new int[]{1}));
        System.out.println(0 == solution.findPeakElement(new int[]{-2147483648}));
        System.out.println(1 == solution.findPeakElement(new int[]{1, 3}));
        System.out.println(0 == solution.findPeakElement(new int[]{3, 2, 1}));
        System.out.println(0 == solution.findPeakElement(new int[]{2, 1}));
        System.out.println(2 == solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(5 == solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    // Template 3
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 1, right = nums.length - 2;
        while (left + 1 < right) {
            int middle = left + (right - left) / 2;
            int next = nums[middle + 1];
            int prev = nums[middle - 1];
            if (nums[middle] > next && nums[middle] > prev) {
                left = middle;
            } else {
                right = middle;
            }
        }
        int next = left + 1 > nums.length - 1 ? Integer.MIN_VALUE : nums[left + 1];
        if (nums[left] > next) {
            return left;
        }
        next = right + 1 > nums.length - 1 ? Integer.MIN_VALUE : nums[right + 1];
        if (nums[right] > next) {
            return right;
        }
        return -1;
    }
}
