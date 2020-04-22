package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2019/12/18
 */
public class Lc172 {

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(new Lc172().trailingZeroes1(2147483647));
        System.out.println(System.currentTimeMillis() - a);
    }
//452137076
//452137076
    public int trailingZeroes(int n) {
        int i = 0;
        for (int j = 5; j <= n; j = j + 5) {
            int x = j;
            while (x / 5 >= 0 && x % 5 == 0) {
                x = x / 5;
                i++;
            }
        }
        return i;
    }


    public int trailingZeroes1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
