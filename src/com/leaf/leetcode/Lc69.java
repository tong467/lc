package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/9
 */
public class Lc69 {

    public static void main(String[] args) {
        System.out.println(new Lc69().mySqrt(1));
    }


    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int leaf = 0;
        int right = x;
        while (leaf < right) {
            int center = leaf + (right - leaf) / 2;
            if (overflow(center, center)) {
                right = center;
                continue;
            }
            if (center * center == x || (center * center < x && ((center + 1) * (center + 1) > x || overflow(center + 1,
                    center + 1)))) {
                return center;
            } else if (overflow(center, center) || center * center > x) {
                right = center;
            } else {
                leaf = center;
            }
        }
        return 0;
    }

    public boolean overflow(int x, int y) {
        long r = (long) x * (long) y;
        if ((int) r != r) {
            return true;
        }
        return false;
    }

}
