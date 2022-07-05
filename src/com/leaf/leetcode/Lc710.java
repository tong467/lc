package com.leaf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2022/6/26
 */
public class Lc710 {

    public static void main(String[] args) {
        Lc710 lc710 = new Lc710(10, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        while (true) {
            System.out.println(lc710.pick());
        }
    }


    private Map<Integer, Integer> value;
    private int bound;
    private Random random;

    public Lc710(int n, int[] blacklist) {
        this.value = new HashMap<>();
        this.random = new Random();
        this.bound = n - blacklist.length;

        Set<Integer> set = new HashSet<>();
        for (int b : blacklist) {
            set.add(b);
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (set.contains(w)) {
                    w++;
                }
                value.put(b, w++);
            }
        }
    }

    public int pick() {
        int i = random.nextInt(bound);
        return value.getOrDefault(i, i);
    }
}
