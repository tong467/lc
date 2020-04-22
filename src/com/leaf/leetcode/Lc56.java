package com.leaf.leetcode;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/4/16
 */
public class Lc56 {

    public static void main(String[] args) {
        int[][] a = new Lc56().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        System.out.println(a);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        //排序
//        for (int i = 0; i < intervals.length; i++) {
//            for (int j = i + 1; j < intervals.length; j++) {
//                if (intervals[i][0] > intervals[j][0]) {
//                    int temp0 = intervals[i][0];
//                    int temp1 = intervals[i][1];
//                    intervals[i][0] = intervals[j][0];
//                    intervals[i][1] = intervals[j][1];
//                    intervals[j][0] = temp0;
//                    intervals[j][1] = temp1;
//                }
//            }
//        }
        Arrays.sort(intervals, comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            int[] last = list.get(list.size() - 1);
            if (last[1] < intervals[i][0]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][2]);
//        int k = 0;
//        int length = intervals.length - 1;
//
//        for (int i = 0; i < length; ) {
//            //需要合并
//            if (intervals[i][1] >= intervals[i + 1][0]) {
//                if (intervals[i][1] < intervals[i + 1][1]) {
//                    intervals[i][1] = intervals[i + 1][1];
//                }
//                //后面数据向前补齐；
//                for (int j = i + 1; j < intervals.length - 1; j++) {
//                    intervals[j][0] = intervals[j + 1][0];
//                    intervals[j][1] = intervals[j + 1][1];
//                }
//                length--;
//            } else {
//                i++;
//                k++;
//            }
//        }
//
//        int[][] result1 = new int[k + 1][2];
//        for (int i = 0; i < k + 1; i++) {
//            result1[i][0] = intervals[i][0];
//            result1[i][1] = intervals[i][1];
//        }

//        return result1;
    }

    private void quickSort(int[][] arr, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = arr[left][0];
            int[] temp = arr[left];
            // 将小于x放到x的前面，大于x的放到x的前面
            while (i < j) {
                // 从后向前找到第一个小于x的值
                while (i < j && arr[j][0] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                // 从后向前找到第一个大于等于x的值
                while (i < j && arr[i][0] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = temp;
            // 分治
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
