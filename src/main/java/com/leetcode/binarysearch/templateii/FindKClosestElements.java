package com.leetcode.binarysearch.templateii;

import java.util.Arrays;
import java.util.List;

class FindKClosestElements {

    public static void main(String[] args) {
        var solution = new FindKClosestElements();
        System.out.println(List.of(1, 2, 3, 4).equals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)));
        System.out.println(List.of(1, 2, 3, 4).equals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)));
        System.out.println(List.of(1, 2, 4).equals(solution.findClosestElements(new int[]{1, 2, 4, 5, 6}, 3, 3)));
        System.out.println(List.of(-2, -1, 1, 2, 3, 4, 5).equals(solution.findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3)));
        System.out.println(List.of(2).equals(solution.findClosestElements(new int[]{2, 4}, 1, 3)));
        System.out.println(List.of(10).equals(solution.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9))); // 10
        System.out.println(List.of(2, 3, 4, 5).equals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6))); // 2, 3, 4, 5
        System.out.println(List.of(1, 2, 3, 4, 5).equals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 6, 6))); // 1, 2, 3, 4, 5
        System.out.println(List.of(0, 1, 1, 1, 2, 3, 6, 7, 8).equals(solution.findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4))); // 0,1,1,1,2,3,6,7,8
        System.out.println(List.of(3, 3, 4).equals(solution.findClosestElements(new int[]{0, 0, 2, 3, 3, 4, 7, 7, 8}, 3, 5))); // 3,3,4
        System.out.println(List.of(3, 6, 8, 8, 9).equals(solution.findClosestElements(new int[]{0, 1, 2, 2, 2, 3, 6, 8, 8, 9}, 5, 9))); // 3,6,8,8,9
        System.out.println(List.of(2, 3, 3).equals(solution.findClosestElements(new int[]{1, 1, 2, 2, 2, 2, 2, 3, 3}, 3, 3)));
        System.out.println(List.of(12, 12, 13).equals(solution.findClosestElements(new int[]{1, 1, 2, 2, 3, 3, 6, 7, 8, 9, 9, 11, 11, 12, 12, 12, 13, 15, 18, 18, 21, 22, 22, 23, 25, 25, 32, 33, 34, 37, 37, 38, 38, 39, 39, 40, 41, 43, 43, 45, 45, 46, 46, 48, 48, 49, 50, 50, 53, 53, 54, 54, 56, 57, 57, 58, 58, 60, 60, 61, 62, 63, 63, 66, 69, 70, 71, 71, 71, 74, 75, 75, 76, 76, 80, 81, 81, 82, 84, 86, 86, 87, 87, 87, 88, 90, 91, 93, 93, 93, 94, 94, 94, 95, 96, 97, 98, 98, 98, 99}, 3, 13))); // 12,12,13
    }

    // Template 2
    public List<Integer> findClosestElements(int[] nums, int k, int target) {
        int left = 0, right = nums.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target - nums[mid] > nums[mid + k] - target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.stream(nums)
                .skip(left)
                .limit(k)
                .boxed()
                .toList();
    }

    // Template 3
//    public List<Integer> findClosestElements(int[] nums, int k, int target) {
//        int left = 0, right = nums.length - k;
//        while (left + 1 < right) {
//            int mid = left + (right - left) / 2;
//            if (target - nums[mid] > nums[mid + k] - target) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//        if (target - nums[left] > nums[left + k] - target) {
//            left = right;
//        }
//        return Arrays.stream(nums)
//                .skip(left)
//                .limit(k)
//                .boxed()
//                .toList();
//    }
}
