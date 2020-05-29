package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/19
 */
public class Lc680 {

    public static void main(String[] args) {
        System.out.println(new Lc680().validPalindrome("abcraetysca"));
    }

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, true);
    }

    public boolean validPalindrome(String s, int left, int right, boolean isDelate) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else {
                if (isDelate) {
                    return validPalindrome(s, left + 1, right, false) || validPalindrome(s, left, right - 1, false);
                }
                return false;
            }
        }
        return true;
    }


}
