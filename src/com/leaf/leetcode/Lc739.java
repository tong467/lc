package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/11
 */
public class Lc739 {

    public int[] dailyTemperatures(int[] T) {
        int[] rArray = new int[T.length];

        for (int i = 0; i < rArray.length; i++) {
            int value = 0;
            int tValue = T[i];
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    value = j - i;
                    break;
                }
            }
            rArray[i] = value;
        }
        return rArray;
    }
}
