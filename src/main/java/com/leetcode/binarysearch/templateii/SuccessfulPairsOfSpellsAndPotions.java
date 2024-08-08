package com.leetcode.binarysearch.templateii;

import java.util.Arrays;

class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        var solution = new SuccessfulPairsOfSpellsAndPotions();
        System.out.println(Arrays.toString(solution.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
        System.out.println(Arrays.toString(solution.successfulPairs(new int[]{1}, new int[]{1}, 2)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        return Arrays.stream(spells)
                .map(spell -> potions.length
                              - Math.max(binarySearch(potions, spell, success), 0))
                .toArray();
    }

    private int binarySearch(int[] array, int multiplier, long success) {
        int left = 0, right = array.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if ((long) array[middle] * multiplier < success) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }
}
