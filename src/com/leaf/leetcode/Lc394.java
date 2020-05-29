package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/28
 */
public class Lc394 {

    public static void main(String[] args) {
        System.out.println(new Lc394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        String[] oneArray = s.split("]");
        StringBuilder sb = new StringBuilder();

        for (String str : oneArray) {
            String[] twoArray = str.split("\\[");
            int length = Integer.parseInt(twoArray[0]);
            for (int i = 0; i < length; i++) {
                sb.append(twoArray[1]);
            }
        }
        return sb.toString();

    }
}
