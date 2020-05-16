package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/2
 */
public class Lc3 {

    public static void main(String[] args) {
        System.out.println(new Lc3().lengthOfLongestSubstring("abcac1nngc"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] cArray = s.toCharArray();

        int leaf = 0;
        int right = 0;
        int max = 0;

        for (; right < cArray.length; right++) {
            int tempLeaf = leafIndex(cArray, leaf, right);
            if (tempLeaf != -1) {
                leaf = tempLeaf;
            }
            max = Math.max(max, right - leaf+1);
        }
        return max;
    }

    private int leafIndex(char[] cArray, int leaf, int right) {
        while (leaf < right) {
            if (cArray[leaf] == cArray[right]) {
                return leaf + 1;
            }
            leaf++;
        }
        return -1;
    }

}
