package com.leetcode.binarysearch.templateii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class FindRightInterval {

    public static void main(String[] args) {
        var solution = new FindRightInterval();
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{1, 2}}))); // -1
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{4, 4}}))); // 0
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}}))); // [-1,0,1]
        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}}))); // [-1,2,-1]
    }

    public int[] findRightInterval(int[][] intervals) { // O(nlogn)
        if (intervals.length == 1) {
            return intervals[0][0] == intervals[0][1]
                    ? new int[]{0}
                    : new int[]{-1};
        }
        int[][] starts = IntStream.range(0, intervals.length)
                .mapToObj(index -> new int[]{intervals[index][0], index})
                .sorted(Comparator.comparing(ints -> ints[0]))
                .toArray(int[][]::new);
        return Arrays.stream(intervals)
                .mapToInt(ints -> binarySearch(starts, ints[1]))
                .toArray();

    }

    private int binarySearch(int[][] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left][0] >= target ? nums[left][1] : -1;
    }
}