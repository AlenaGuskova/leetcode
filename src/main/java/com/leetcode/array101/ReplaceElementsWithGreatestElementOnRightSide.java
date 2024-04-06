package com.leetcode.array101;

import java.util.Arrays;
import java.util.LinkedList;

class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        var solution = new ReplaceElementsWithGreatestElementOnRightSide();

        var nums1 = solution.replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println(Arrays.toString(nums1) + " " + Arrays.equals(nums1, new int[]{18, 6, 6, 6, 1, -1}));

        var nums2 = solution.replaceElements(new int[]{400});
        System.out.println(Arrays.toString(nums2) + " " + Arrays.equals(nums2, new int[]{-1}));
    }

    public int[] replaceElements(int[] arr) {
        Stack stack = new Stack();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = arr[i];
            stack.push(j);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = stack.max();
        }
        return result;
    }

    private static class Stack {

        private final LinkedList<Integer> max;

        public Stack() {
            max = new LinkedList<>();
        }

        public void push(Integer value) {
            max.push(Math.max(value, max.isEmpty() ? -1 : max.getFirst()));
        }

        public int max() {
            return max.isEmpty() ? -1 : max.pollFirst();
        }
    }
}
