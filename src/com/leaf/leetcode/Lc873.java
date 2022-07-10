package com.leaf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2022/7/9
 */
public class Lc873 {

    public static void main(String[] args) {
        System.out.println(new Lc873().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
//         4  14  18 32 50
    }

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int length = 0, x1 = 0, x2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                x1 = arr[i];
                x2 = arr[j];
                int tempLength = 0;
                int x3 = x1 + x2;
                while (map.containsKey(x3)) {
                    x1 = x2;
                    x2 = x3;
                    x3 = x1 + x2;
                    tempLength++;
                    length = Math.max(length, tempLength);
                }
            }
        }
        return length != 0 ? length + 2 : 0;
    }
}
