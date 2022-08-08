package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongshujian
 * @date 2022/8/4
 */
public class Lc1403 {

    public static void main(String[] args) {
        System.out.println(new Lc1403().minSubsequence(new int[]{4,3,10,9,8}));
    }

    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);

        int minTotal = 0;
        int maxTotal = 0;

        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (maxTotal > minTotal) {
                minTotal += nums[i];
                if (maxTotal > minTotal) {
                    i++;
                } else {
                    minTotal -= nums[i];
                    maxTotal += nums[j];
                    result.add(nums[j]);
                    j--;
                }
            } else {
                maxTotal += nums[j];
                result.add(nums[j]);
                j--;
            }
        }
        return result;
    }
}
