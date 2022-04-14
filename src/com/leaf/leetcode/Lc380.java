package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2022/4/14
 */
public class Lc380 {


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        randomizedSet.insert(4);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());

    }
}

class RandomizedSet {

    private Set<Integer> set = new HashSet<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int size = set.size();
        Integer[] a = set.toArray(new Integer[0]);
        return a[new Random().nextInt(size)];
    }
}

