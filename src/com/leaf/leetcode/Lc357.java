package com.leaf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2022/4/11
 */
public class Lc357 {

    //8 2345851
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(
                    new Lc357().countNumbersWithUniqueDigits(i) + " == " + new Lc357().countNumbersWithUniqueDigits1(
                            i));
        }
    }


    public int countNumbersWithUniqueDigits1(int n) {
        int[] dp = new int[9];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (uniqueDigits(i) + dp[i - 1]);
        }
        return dp[n];
    }


    private int uniqueDigits(int n) {
        int num = 9;
        int total = 9;
        for (int i = 1; i < n; i++) {
            total = total * (num--);
        }
        return total;
    }


    public int countNumbersWithUniqueDigits(int n) {
        int total = 0;
        for (int i = 0; i < Math.pow(10, n); i++) {
            if (isUniqueDigits(i)) {
                total++;
            }
        }
        return total;
    }

    private boolean isUniqueDigits(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 0) {
            int y = n % 10;
            if (set.contains(y)) {
                return false;
            } else {
                set.add(y);
            }
            n = n / 10;
        }
        return true;
    }
}
