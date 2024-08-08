package com.leetcode.binarysearch.templateii;

class FindPeakElement {

    public static void main(String[] args) {
        var solution = new FindPeakElement();
        System.out.println(solution.findPeakElement(new int[]{1}));
        System.out.println(solution.findPeakElement(new int[]{-2147483648}));
        System.out.println(solution.findPeakElement(new int[]{1, 3}));
        System.out.println(solution.findPeakElement(new int[]{3, 2, 1}));
        System.out.println(solution.findPeakElement(new int[]{2, 1}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
