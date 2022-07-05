package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/6/30
 */
public class Lc1175 {

    public static void main(String[] args) {
        System.out.println(new Lc1175().isPrimeArrangements(4));
    }

//    public int numPrimeArrangements(int n) {
//        for (int i)
//
//        return 1;
//    }

    private boolean isPrimeArrangements(int k) {
        for (int i = 2; i < k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

}
