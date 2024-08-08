package com.leetcode.binarysearch.templatei;

public class SqrtX {

    public static void main(String[] args) {
        var solution = new SqrtX();
        System.out.println(2 == solution.mySqrt(4));
        System.out.println(0 == solution.mySqrt(0));
        System.out.println(2 == solution.mySqrt(8));
        System.out.println(46339 == solution.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            long srt = (long) middle * middle;
            if (srt == x) {
                return middle;
            }
            if (srt > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left - 1;
    }
}
