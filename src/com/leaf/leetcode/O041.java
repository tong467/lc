package com.leaf.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2022/7/16
 */
public class O041 {

    public static void main(String[] args) {

    }

}

    class MovingAverage {

        List<Integer> list;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            list = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (list.size() >= size) {
                list.remove(0);
            }
            list.add(val);
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i);
            }
            return total / (double) val;

        }
    }