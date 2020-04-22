package com.leaf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2019/12/17
 */
public class Lc167 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i =0;i<numbers.length;i++){
            int b = target - numbers[i];
            if(numMap.get(b)!=null){
                return new int[]{numMap.get(b)+1,i+1};
            }else{
                numMap.put(numbers[i],i);
            }
        }
        return null;
    }
}
