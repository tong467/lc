package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/30
 */
public class MaxScore {

    public static void main(String[] args) {
        System.out.println(new MaxScore().maxScore("01001"));
    }

    public int maxScore(String s) {
        char[] cArray = s.toCharArray();
        int max = 0;
        for (int i = 1; i < cArray.length; i++) {
            max = Math.max(maxScore(i, cArray), max);
        }
        return max;
    }


    public int maxScore(int center, char[] cArray) {

        int length = Math.max(center, cArray.length - center + 1);
        int score = 0;
        for (int i = 1; i <= length; i++) {
            if (center - i >= 0) {
                if (cArray[center - i] == '0') {
                    score += 1;

                }
            }
            if (center + i - 1 < cArray.length) {
                if (cArray[center + i - 1] == '1') {
                    score += 1;
                }
            }
        }
        return score;
    }
}
