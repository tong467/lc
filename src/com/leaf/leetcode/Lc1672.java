package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/4/14
 */
public class Lc1672 {

    public static void main(String[] args) {
        System.out.println(new Lc1672().maximumWealth(new int[][]{{1, 2, 3}, {1, 2, 4}}));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tempMax += accounts[i][j];
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
