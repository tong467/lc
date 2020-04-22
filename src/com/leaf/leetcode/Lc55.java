package com.leaf.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tongshujian
 * @date 2020/4/17
 */
public class Lc55 {

    public static void main(String[] args) {
        System.out.println(new Lc55().canJump(
                new int[]{1}));
    }

    public boolean canJump(int[] nums) {
        //最远值
        int bengin = 0;
        int end = nums[0];

        int start = bengin;
        int last = end;
        while (true) {
            for (int i = bengin; i <= end; i++) {
                if (last >= nums.length - 1) {
                    return true;
                }
                if (i + nums[i] > last) {
                    last = i + nums[i];
                    start = i;
                }
            }
            if (last > end) {
                bengin = start;
                end = last;
            } else {
                return false;
            }
        }

//        int target = nums.length;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, nums[0]});
//        while (!queue.isEmpty()) {
//            int[] stepArray = ((LinkedList<int[]>) queue).pop();
//            if (stepArray[1] >= target) {
//                return true;
//            }
//            for (int i = stepArray[0] + 1; i <= stepArray[0] + stepArray[1]; i++) {
//                if (nums[i] + i >= target) {
//                    return true;
//                } else if (nums[i] != 0) {
//                    queue.add(new int[]{i, nums[i]});
//                }
//            }
//        }
//        return false;
    }

}
