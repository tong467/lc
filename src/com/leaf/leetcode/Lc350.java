package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] nums3;
        if (nums1.length > nums1.length) {
            nums3 = nums1;
            nums1 = nums2;
            nums2 = nums3;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < nums1.length; i++) {
            for (; j < nums2.length && i < nums1.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                    i++;
                } else if (nums1[i] < nums2[j]) {
                    break;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
