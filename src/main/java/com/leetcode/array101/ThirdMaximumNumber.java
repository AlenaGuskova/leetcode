package com.leetcode.array101;

class ThirdMaximumNumber {

    public static void main(String[] args) {
        var solution = new ThirdMaximumNumber();

        System.out.println(1 == solution.thirdMax(new int[]{3, 2, 1}));
        System.out.println(2 == solution.thirdMax(new int[]{1, 2}));
        System.out.println(1 == solution.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(10 == solution.thirdMax(new int[]{10, 2}));
        System.out.println(2 == solution.thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
        System.out.println(-2147483648 == solution.thirdMax(new int[]{1, 2, -2147483648}));
        System.out.println(-2147483648 == solution.thirdMax(new int[]{1, -2147483648, 2}));
        System.out.println(1 == solution.thirdMax(new int[]{-2147483648, 1, 1}));
    }

    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num != max2 && num != max1) {
                max3 = num;
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
