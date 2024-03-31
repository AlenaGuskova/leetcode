package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
    public static void main(String[] args) {
//        var nums = new int[]{0, 1, 2, 4, 5, 7};
//        var nums = new int[]{0, 2, 3, 4, 6, 8, 9};
//        var nums = new int[]{-2147483648, -2147483647, 2147483647};
        var nums = new int[]{-1};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return List.of();
        if (nums.length == 1) return List.of(Integer.toString(nums[0]));

        var result = new ArrayList<String>();
        var start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                result.add(getRange(start, nums, i - 1));
                start = nums[i];
            }
            if (i == nums.length - 1) {
                result.add(getRange(start, nums, i));
            }
        }
        return result;
    }

    private String getRange(int start, int[] nums, int i) {
        return start == nums[i] ? Integer.toString(start) : concat(start, nums[i]);
    }

    private String concat(int start, int nums) {
        return Integer.toString(start).concat("->").concat(Integer.toString(nums));
    }
}
