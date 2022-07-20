package com.leaf.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                deque.add(grid[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            int node = deque.pollLast();
            deque.addFirst(node);
        }
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            List<Integer> nodeList = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                nodeList.add(deque.pollFirst());
            }
            list.add(nodeList);
        }
        return list;
    }
}
