package com.leetcode.array101;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        var solution = new CheckIfNAndItsDoubleExist();

        var nums1 = new int[]{10, 2, 5, 3};
        System.out.println(solution.checkIfExist(nums1));

        var nums2 = new int[]{3, 1, 7, 11};
        System.out.println(!solution.checkIfExist(nums2));
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> elementsToIndex = new HashSet<>();
        boolean result = false;
        for (int j : arr) {
            if (elementsToIndex.contains(2 * j) || (j % 2 == 0 && elementsToIndex.contains(j / 2))) {
                result = true;
                break;
            } else {
                elementsToIndex.add(j);
            }
        }
        return result;
    }
}
