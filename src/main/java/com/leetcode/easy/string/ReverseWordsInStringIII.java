package com.leetcode.easy.string;

class ReverseWordsInStringIII {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        var s = "Let's take LeetCode contest";
        System.out.println(new ReverseWordsInStringIII().reverseWords(s));

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public String reverseWords(String s) {
        String[] words = s.split(SPACE);
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i != words.length - 1) {
                result.append(SPACE);
            }
        }
        return result.toString();
    }
}
