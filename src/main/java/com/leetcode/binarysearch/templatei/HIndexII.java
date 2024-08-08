package com.leetcode.binarysearch.templatei;

class HIndexII {

    public static void main(String[] args) {
        var solution = new HIndexII();

        System.out.println(2 == solution.hIndex(new int[]{11, 15}));
        System.out.println(0 == solution.hIndex(new int[]{0, 0, 0}));
        System.out.println(1 == solution.hIndex(new int[]{100}));
        System.out.println(0 == solution.hIndex(new int[]{0}));
        System.out.println(1 == solution.hIndex(new int[]{0, 1}));

        System.out.println(3 == solution.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(2 == solution.hIndex(new int[]{1, 2, 100}));
    }

    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (citations[middle] == citations.length - middle) {
                return citations[middle];
            } else if (citations[middle] < citations.length - middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return citations.length - left;
    }
}
