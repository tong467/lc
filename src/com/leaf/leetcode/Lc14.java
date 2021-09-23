package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/15
 */
public class Lc14 {

    public static void main(String[] args) {
        new Lc14().longestCommonPrefix(new String[]{""});
    }


    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        lab:
        while (true) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    break lab;
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}
