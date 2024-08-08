package com.leetcode.binarysearch.templateii;

class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        var solution = new FindSmallestLetterGreaterThanTarget();
        System.out.println('c' == solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println('f' == solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println('f' == solution.nextGreatestLetter(new char[]{'c', 'c', 'f', 'j'}, 'c'));
        System.out.println('x' == solution.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y', 'y'}, 'z'));
        System.out.println('f' == solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (letters[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return letters[left] > target ? letters[left] : letters[0];
    }
}
