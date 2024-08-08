package com.leetcode.binarysearch.templateii;

class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return isBadVersion(left) ? left : -1;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }
}
