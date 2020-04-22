package com.leaf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2019/12/17
 */
public class Lc169 {

    public static void main(String[] args) {
        System.out.println(new Lc169().majorityElement(new int[]{6, 6, 6, 7, 7}));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            Integer valueSize = map.get(i);
            if (valueSize != null) {
                if (valueSize + 1 <= nums.length / 2) {
                    map.put(i, valueSize + 1);
                } else {
                    return i;
                }
            } else {
                map.put(i, 1);
            }
        }
        return 0;
    }
}
