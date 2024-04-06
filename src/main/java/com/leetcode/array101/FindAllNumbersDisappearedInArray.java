package com.leetcode.array101;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        var solution = new FindAllNumbersDisappearedInArray();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(solution.findDisappearedNumbers(new int[]{1, 1}));

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        var allNumbers = IntStream.rangeClosed(1, nums.length)
                .boxed()
                .collect(Collectors.toSet());

        for (int num : nums) {
            allNumbers.remove(num);
        }
        return new ArrayList<>(allNumbers);
    }
}
