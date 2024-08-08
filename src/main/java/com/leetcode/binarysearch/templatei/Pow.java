package com.leetcode.binarysearch.templatei;

class Pow {

    public static void main(String[] args) {
        var solution = new Pow();
        System.out.println(Math.abs(1024.00000 - solution.myPow(2.00000, 10)) <= 0.0001);
        System.out.println(Math.abs(9.26100 - solution.myPow(2.10000, 3)) <= 0.0001);
        System.out.println(Math.abs(0.25 - solution.myPow(2.00000, -2)) <= 0.0001);
        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long exponent = Math.abs((long) n); // overflow on -2147483648
        if (n < 0) {
            x = 1 / x;
        }
        return myPow(x * x, (int) (exponent / 2)) * (exponent % 2 == 0 ? 1 : x);
    }
}
