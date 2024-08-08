package com.leetcode.binarysearch.templatei;

class SingleElementInSortedArray {

    public static void main(String[] args) {
        var solution = new SingleElementInSortedArray();
        System.out.println(2 == solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(10 == solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(1 == solution.singleNonDuplicate(new int[]{1}));
        System.out.println(2 == solution.singleNonDuplicate(new int[]{1, 1, 2}));
        System.out.println(3 == solution.singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));

        System.out.println(1 == solution.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
        System.out.println(1 == solution.singleNonDuplicate(new int[]{1, 4, 4}));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length < 3) return nums[0];

        int left = 1, right = nums.length - 2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] != nums[middle - 1] && nums[middle] != nums[middle + 1]) {
                return nums[middle];
            } else if ((nums[middle] != nums[middle + 1] && middle % 2 == 0)
                    || (nums[middle] != nums[middle - 1] && middle % 2 == 1)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left == nums.length - 1 ? nums[left] : nums[right];
    }
}
