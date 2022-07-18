package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2022/7/17
 */
public class Lc565 {

    public static void main(String[] args) {
        System.out.println(new Lc565().arrayNesting(new int[]{1, 0, 3, 4, 2}));
    }

    public int arrayNesting(int[] nums) {
        int max = 0;
        int[] bel = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (bel[i] != 0) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int tempMax = 0;
            int j = i;
            while (!set.contains(j) && bel[j] == 0) {
                set.add(j);
                j = nums[j];
                tempMax++;
            }
            j = i;
            set = new HashSet<>();
            while (!set.contains(j)) {
                set.add(j);
                j = nums[j];
                bel[j] = tempMax;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public int arrayNesting1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int tempMax = 0;
            int j = i;
            while (!set.contains(j)) {
                set.add(j);
                j = nums[j];
                tempMax++;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }


}
