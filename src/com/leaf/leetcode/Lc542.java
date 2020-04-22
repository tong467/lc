package com.leaf.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tongshujian
 * @date 2020/4/15
 */
public class Lc542 {

    public static void main(String[] args) {

        new Lc542().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }


    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    //不为零 需要被搜索的位置
                    matrix[i][j] = -1;
                }
            }
        }

        while (queue.size() != 0) {
            int[] cArray = ((LinkedList<int[]>) queue).pop();
            int x = cArray[0];
            int y = cArray[1];
            //上
            if (y - 1 >= 0) {
                //没有被搜索过
                if (matrix[x][y - 1] == -1) {
                    matrix[x][y - 1] = matrix[x][y] + 1;
                    queue.add(new int[]{x, y - 1});
                }
            }
            //下
            if (y + 1 < matrix[x].length) {
                //没有被搜索过
                if (matrix[x][y + 1] == -1) {
                    matrix[x][y + 1] = matrix[x][y] + 1;
                    queue.add(new int[]{x, y + 1});
                }
            }
            //左
            if (x - 1 >= 0) {
                //没有被搜索过
                if (matrix[x - 1][y] == -1) {
                    matrix[x - 1][y] = matrix[x][y] + 1;
                    queue.add(new int[]{x - 1, y});
                }

            }
            //右
            if (x + 1 < matrix.length) {
                //没有被搜索过
                if (matrix[x + 1][y] == -1) {
                    matrix[x + 1][y] = matrix[x][y] + 1;
                    queue.add(new int[]{x + 1, y});
                }
            }
        }
        return matrix;
    }
}
