package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2019/12/17
 */
public class Lc168 {




    public static void main(String[] args) {
        Lc168 lc168 = new Lc168();
        System.out.println(lc168.convertToTitle(28));
    }
    String[] letter = new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int length = letter.length - 1;

        while (n > 0) {
            if (n % length == 0) {
                sb.insert(0, letter[length]);
            } else {
                sb.insert(0, letter[n % length]);
            }
            n = (n - 1) / length;
        }

        return sb.toString();
    }

}
