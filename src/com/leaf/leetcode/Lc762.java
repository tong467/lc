package com.leaf.leetcode;

/**
 * https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/
 *
 * @author tongshujian
 * @date 2022/4/10
 */
public class Lc762 {

    public static void main(String[] args) {
        System.out.println(new Lc762().countPrimeSetBits(10, 15));
    }

    public int countPrimeSetBits(int left, int right) {
        int total = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                total++;
            }
        }
        return total;
    }

    private boolean isPrime(int i) {
        if (i == 0 || i == 1) {
            return false;
        } else if (i == 2) {
            return true;
        } else {
            return i % 2 != 0;
        }
    }
}

