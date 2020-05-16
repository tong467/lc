package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/5/14
 */
public class Lc136 {


    public static void main(String[] args) {
        new Lc136().a(0);
    }

    public void a(int i) {
        System.out.println(i++);
        a(i);
    }


    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }


    public int singleNumber1(int[] nums) {
        Set<Integer> iSet = new HashSet<>();
        for (int i : nums) {
            if (iSet.contains(i)) {
                iSet.remove(i);
            } else {
                iSet.add(i);
            }
        }
        return ((Integer[]) iSet.toArray(new Integer[0]))[0];
    }
}
