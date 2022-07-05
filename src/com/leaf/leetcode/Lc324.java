package com.leaf.leetcode;

import java.util.Arrays;

/**
 * @author tongshujian
 * @date 2022/6/28
 */
public class Lc324 {


    public static void main(String[] args) {
        new Lc324().wiggleSort(new int[]{1, 1, 1, 1, 2, 2, 2});

    }

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int left = (nums.length - 1) / 2, right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }

        System.out.println(nums);
    }

}
