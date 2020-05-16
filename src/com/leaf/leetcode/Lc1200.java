package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/4/25
 */
public class Lc1200 {

    public static void main(String[] args) {
        new Lc1200().minimumAbsDifference(new int[]{4, 2, 1, 3});
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
                //清空最小值列表
                result.clear();
                List<Integer> inner = new ArrayList<>();
                inner.add(arr[i]);
                inner.add(arr[i + 1]);
                result.add(inner);
            } else if (arr[i + 1] - arr[i] == min) {
                //加入最小值列表
                List<Integer> inner = new ArrayList<>();
                inner.add(arr[i]);
                inner.add(arr[i + 1]);
                result.add(inner);
            }
        }
        return result;

    }

}
