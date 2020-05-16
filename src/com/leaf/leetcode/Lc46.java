package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tongshujian
 * @date 2020/4/25
 */
public class Lc46 {

    public static void main(String[] args) {
        List list = new Lc46().permute(new int[]{1, 2, 3});
        System.out.println(list.size());
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            result.add(temp);
        }

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tempResult = new ArrayList<>();
            int j = 0;
            laber:
            for (int k = 0; k < result.size(); ) {
                List<Integer> integers = result.get(k);
                List<Integer> tempIner = new ArrayList<>();
                tempIner.addAll(integers);
                for (; j < nums.length; j++) {
                    if (!integers.contains(nums[j])) {
                        tempIner.add(nums[j]);
                        tempResult.add(tempIner);
                        j++;
                        continue laber;
                    }

                }
                k++;
                j = 0;
            }
            result = tempResult;
        }
        return result;
    }


}
