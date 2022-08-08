package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/8/1
 */
public class Lc1374 {

    public static void main(String[] args) {
        System.out.println(new Lc1374().generateTheString(3));
    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }
        return sb.toString();
    }

}
