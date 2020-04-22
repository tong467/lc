package com.leaf.leetcode;

import java.time.chrono.MinguoChronology;

/**
 * @author tongshujian
 * @date 2020/4/18
 */
public class Lc11 {

    public static void main(String[] args) {
//        new Lc11().maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(11%2);
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        //相等就是相遇了结束循环
        while (left < right) {
            //矮柱子高度
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * min);
            //如果柱子变的更矮就继续移动
            while (left < right && min >= height[left]) {
                left++;
            }
            while (left < right && min >= height[right]) {
                right--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int min = height[l] < height[r] ? height[l]:height[r];
            max = Math.max(max, min * (r-l));
            while (l<r && height[l] <= min) l++;
            while (l< r && height[r] <= min) r--;

        }
        return max;
    }


    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;

    }
}
