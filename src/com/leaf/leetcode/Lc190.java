package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/1/3
 */
public class Lc190 {

    public static void main(String[] args) {
        int n = 15;

        int[] iArray = new int[32];
        int temp = n;
        int i = 0;
        while (temp > 0) {
            if (i != 0) {
                double j = Math.pow(2, i);
                temp = n - (int) j;
                n = temp;
                if (temp != 0) {
                    i = 0;
                }
            }
            while (temp / 2 != 0) {
                i++;
                temp = temp / 2;
            }
            iArray[i] = 1;
        }
        System.out.println("11");
    }

}
