package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2022/4/13
 */
public class Lc806 {


    public int[] numberOfLines(int[] widths, String s) {
        int start = 97;
        int length = 100;
        char[] chars = s.toCharArray();

        int tempLength = 0;
        int line = 0;

        for (char c : chars) {
            int cLength = widths[(int) c - start];
            if (tempLength + cLength > length) {
                tempLength = cLength;
                line++;
            } else if (tempLength == length) {
                line++;
                tempLength = 0;
            } else {
                tempLength += cLength;
            }
        }
        if (tempLength != 0) {
            line++;
        }
        return new int[]{line, tempLength};
    }

    public static void main(String[] args) {
        int[] arr = new Lc806().numberOfLines(
                new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10}, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(arr[0] + "-" + arr[1]);
    }
}
