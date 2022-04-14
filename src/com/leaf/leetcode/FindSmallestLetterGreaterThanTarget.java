package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/4/3
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int leaf = 0, right = letters.length - 1, middle = (leaf + right) / 2;
        while (middle < right && middle < letters.length - 1) {
            if (letters[middle] <= target
                    && letters[middle + 1] > target) {
                return letters[middle + 1];
            } else {
                if (letters[middle] > target) {
                    right = middle;
                } else {
                    leaf = middle + 1;
                }
            }
            middle = (leaf + right) / 2;
        }
        return letters[0];
    }

    public static void main(String[] args) {

        System.out.println(
                new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(
                        new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'z'));
    }
}
