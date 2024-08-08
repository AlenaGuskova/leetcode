package com.leetcode.binarysearch.templatei;

class GuessNumberHigherOrLower {

    public static void main(String[] args) {
//        System.out.println(new GuessNumberHigherOrLower().guessNumber(10));
        System.out.println(new GuessNumberHigherOrLower().guessNumber(1));
    }

    public int guessNumber(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int guess = guess(middle);
            if (guess == 0) {
                return middle;
            } else if (guess == -1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private int guess(int num) {
        return Integer.compare(1, num);
    }
}
