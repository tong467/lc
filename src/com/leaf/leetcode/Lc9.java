package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/10
 */
public class Lc9 {

    public static void main(String[] args) {
        System.out.println(new Lc9().isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
