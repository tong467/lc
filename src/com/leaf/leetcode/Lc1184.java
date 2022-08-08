package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/7/24
 */
public class Lc1184 {

    public static void main(String[] args) {
        System.out.println(new Lc1184().distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int temp = start;
        if (start > destination) {
            start = destination;
            destination = temp;
        }
        int oneTotal = 0;
        int twoTotal = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start <= i && i < destination) {
                oneTotal += distance[i];
            } else {
                twoTotal += distance[i];
            }
        }
        return Math.min(oneTotal, twoTotal);
    }

}
