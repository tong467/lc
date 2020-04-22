package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/22
 */
public class Lc239 {

    public static void main(String[] args) {

     new Lc239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int head = 0;
        int i =0;
        int[] result = new int[nums.length - k + 1];
        while (k <= nums.length) {
            result[i] = maxValue(nums, head, k);
            i++;
            head++;
            k++;
        }
        return result;
    }

    private int maxValue(int[] nums, int head, int last) {
        int currentMax = Integer.MIN_VALUE;
        for (int i = head; i < last; i++) {
            currentMax = currentMax < nums[i] ? nums[i] : currentMax;
        }
        return currentMax;
    }
}
