package com.leetcode.easy.string;

class IsSubsequence {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        var s = "axb";
        var t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t)); // true

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public boolean isSubsequence(String s, String t) {
        var i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}
