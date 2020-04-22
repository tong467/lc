package com.leaf.leetcode;

public class Lc53 {

    public static void main(String[] args) {

        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(a - 1);
        System.out.println(b);
        System.out.println("2013-12-12".substring(0, 11) + "00:00:00");

        Lc53 lc53 = new Lc53();
        System.out.println(lc53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            res = Math.max(res, nums[i]);
        }
        return nums.length != 1 ? res : nums[0];
    }


}