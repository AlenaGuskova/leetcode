package com.leetcode.array101;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        var solution = new FindDuplicateNumber();
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2})); // 3
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(solution.findDuplicate(new int[]{3, 3, 3, 3, 3})); // 3
    }

    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
            }
            nums[cur] *= -1;
        }
        return duplicate;
    }

//    public int findDuplicate(int[] nums) {
//        return Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .get()
//                .getKey();
//
//    }
}
