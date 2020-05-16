package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/4/30
 */
public class Lc202 {

    public static void main(String[] args) {
        System.out.println(new Lc202().isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> hset = new HashSet<>();
        int result = 0;
        while (result != 1) {
            result = 0;
            while (n != 0) {
                int x = n % 10;
                n = n / 10;
                result += (x * x);
            }
            n = result;
            if (hset.contains(result)) {
                return false;
            } else {
                hset.add(result);
            }
        }
        return true;
    }
}
