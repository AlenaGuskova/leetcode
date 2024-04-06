package com.leetcode.array101;

import java.util.Arrays;

class MergeSortedArray {

    public static void main(String[] args) {
        var solution = new MergeSortedArray();

        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1) + " " + Arrays.equals(nums1, new int[]{1, 2, 2, 3, 5, 6}));

        var nums2 = new int[]{0};
        solution.merge(nums2, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums2) + " " + Arrays.equals(nums2, new int[]{1}));

        var nums3 = new int[]{1};
        solution.merge(nums3, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums3) + " " + Arrays.equals(nums3, new int[]{1}));

        var nums4 = new int[]{2, 0};
        solution.merge(nums4, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums4) + " " + Arrays.equals(nums4, new int[]{1, 2}));

        var nums5 = new int[]{1, 0};
        solution.merge(nums5, 1, new int[]{2}, 1);
        System.out.println(Arrays.toString(nums5) + " " + Arrays.equals(nums5, new int[]{1, 2}));

        var nums6 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        solution.merge(nums6, 6, new int[]{1, 2, 2}, 3);
        System.out.println(Arrays.toString(nums6) + " " + Arrays.equals(nums6, new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 3}));

        var nums7 = new int[]{0, 0, 0, 0, 0};
        solution.merge(nums7, 0, new int[]{1, 2, 3, 4, 5}, 5);
        System.out.println(Arrays.toString(nums7) + " " + Arrays.equals(nums7, new int[]{1, 2, 3, 4, 5}));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[nums1.length + 1];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) nums3[k++] = nums1[i++];
            else nums3[k++] = nums2[j++];
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }
        while (j < n) {
            nums3[k++] = nums2[j++];
        }
        System.arraycopy(nums3, 0, nums1, 0, nums1.length);
    }
}
