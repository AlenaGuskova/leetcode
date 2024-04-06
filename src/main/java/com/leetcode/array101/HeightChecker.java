package com.leetcode.array101;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HeightChecker {

    public static void main(String[] args) {
        var solution = new HeightChecker();

        System.out.println(solution.heightChecker(new int[]{10, 2, 5, 3}));
        System.out.println(solution.heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(solution.heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        return (int) IntStream.range(0, heights.length)
                .filter(i -> heights[i] != copy[i])
                .count();
    }
}
