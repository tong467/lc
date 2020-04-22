package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/2/17
 */
public class Lc191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight1(123));
        System.out.println(hammingWeight(123));
    }


    public static int hammingWeight1(int n) {
        int number = 1;
        n = (n & (n - 1));
        while (n != 0) {
            n = (n & (n - 1));
            number++;
        }
        return number;
    }


    public static int hammingWeight(int n) {
        int x = 1;
        int number = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & x) != 0) {
                number++;
            }
            x = x << 1;
        }
        return number;
    }

}
