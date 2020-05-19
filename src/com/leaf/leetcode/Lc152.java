package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/18
 */
public class Lc152 {

    public static void main(String[] args) {
        System.out.println(new Lc152().maxProduct(new int[]{-1, -2, -9, 6}));
    }

    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max ,tempMin = min;
            max = Math.max(Math.max(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            min = Math.min(Math.min(nums[i], tempMin * nums[i]), tempMax * nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    public int maxProduct1(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tempResult = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tempResult *= nums[j];
                result = Math.max(result, tempResult);
            }
        }
        return result;
    }
}
