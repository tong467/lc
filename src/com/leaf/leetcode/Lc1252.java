package com.leaf.leetcode;

public class Lc1252 {
    public static void main(String[] args) {
        new Lc1252().oddCells(2, 3, new int[][]{{0, 1}, {1,1}});
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] mn = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            //行处理
            for (int k = 0; k < n; k++) {
                mn[indices[i][0]][k] = mn[indices[i][0]][k] + 1;
            }
            //列处理
            for (int l = 0; l < m; l++) {
                mn[l][indices[i][1]] = mn[l][indices[i][1]] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < mn.length; i++) {
            for (int j = 0; j < mn[i].length; j++) {
                if (mn[i][j] % 2 != 0) {
                    total++;
                }
            }
        }
        return total;
    }
}
