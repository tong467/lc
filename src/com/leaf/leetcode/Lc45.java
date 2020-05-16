package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/4
 */
public class Lc45 {

    public static void main(String[] args) {
        System.out.println(new Lc45().jump(new int[]{1,2}));
    }

    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int result = 1;
        int leaf = 0;
        int right = nums[0];
        while (leaf + nums[leaf] < nums.length - 1) {
            int newLeaf = 0;
            int max = 0;
            //找打i能到达的最远的下标
            for (; leaf <= right; leaf++) {
                if (leaf + nums[leaf] > max) {
                    max = leaf + nums[leaf];
                    newLeaf = leaf;
                }
            }
            leaf = newLeaf;
            right = leaf + nums[leaf];
            result++;
        }
        return result;
    }
}
