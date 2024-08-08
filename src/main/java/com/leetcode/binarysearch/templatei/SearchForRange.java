package com.leetcode.binarysearch.templatei;

import java.util.Arrays;

class SearchForRange {

    public static void main(String[] args) {
        var solution = new SearchForRange();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // [3,4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 6, 7, 7, 7, 8, 8, 8, 10}, 8))); // [5,7]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))); // [-1,-1]
        System.out.println(Arrays.toString(solution.searchRange(new int[0], 0))); // [-1,-1]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1))); // [-1,-1]
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1, lastIndex = -1;
        if (nums != null && nums.length != 0) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    firstIndex = mid;
                    lastIndex = mid;
                    while ((lastIndex < (nums.length - 1)) && (nums[lastIndex + 1] == target)) {
                        lastIndex++;
                    }
                    while ((firstIndex > 0) && (nums[firstIndex - 1] == target)) {
                        firstIndex--;
                    }
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{firstIndex, lastIndex};
    }
}
