package com.leaf.leetcode;


import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author tongshujian
 * @date 2020/6/24
 */
public class Lc16 {

    public static void main(String[] args) {
        System.out.println(new Lc16().threeSumClosest(new int[]{0, 1, 2}, 0));
    }

    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    map.put(target - sum, sum);
                }
            }
        }
        Entry<Integer, Integer> beginEntry = null;

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                return target;
            } else if (entry.getKey() > 0) {
                if (beginEntry == null) {
                    return entry.getValue();
                } else {
                    if (-beginEntry.getKey() > entry.getKey()) {
                        return entry.getValue();
                    } else {
                        return beginEntry.getValue();
                    }
                }
            }
            beginEntry = entry;
        }
        return beginEntry.getValue();
    }

//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int[] twoSumArray = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            twoSumArray[i] = target - nums[i];
//        }
//        Map<Integer, Integer> map = new TreeMap<>();
//
//        for (int i =0;i<nums.length;i++){
//
//        }
//
//
//    }
//
//    /**
//     * 2分查找离 target 值比较近的值；
//     * @param nums
//     * @param i
//     * @param target
//     * @return
//     */
//    private int closest(int[] nums,int i ,int target){
//
//    }
}
