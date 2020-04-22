package com.leaf.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author tongshujian
 * @date 2020/4/20
 */
public class Lc200 {

    public static void main(String[] args) {

        System.out.println(new Lc200().numIslands(
                new char[][]{
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '0',
                                '1',
                                '1'
                        },
                        {
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0'
                        },
                        {
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '0',
                                '0',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '0',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '1',
                                '1',
                                '1',
                                '1',
                                '0',
                                '0'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        },
                        {
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        }
                }));
    }

    public int numIslands(char[][] grid) {
        int numbers = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //未探索发现新大陆
                if (grid[i][j] == '1') {
                    numbers++;
                    //广度优先将岛屿命名;
                    tag(grid, i, j);
                }
            }
        }
        return numbers;
    }

    public void tag(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        ((LinkedList<int[]>) queue).add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] iArray = ((LinkedList<int[]>) queue).pop();
            i = iArray[0];
            j = iArray[1];
            grid[i][j] = '0';
            //上
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                queue.add(new int[]{i, j - 1});

            }
            //下
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                queue.add(new int[]{i, j + 1});
            }
            //左
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                queue.add(new int[]{i - 1, j});
            }
            //右
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                queue.add(new int[]{i + 1, j});
            }
        }
    }

}
