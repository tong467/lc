package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/23
 */
public class Lc67 {

    public static void main(String[] args) {
        System.out.println(new Lc67().addBinary("", ""));
    }

    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        char carry = '0';

        while (aIndex >= 0 || bIndex >= 0) {
            char aC = getByIndex(a, aIndex);
            char bC = getByIndex(b, bIndex);
            char[] aArray = add(aC, bC, carry);
            carry = aArray[0];
            sb.insert(0, aArray[1]);
            aIndex--;
            bIndex--;
        }
        if (carry == '1') {
            sb.insert(0, carry);
        }
        return sb.toString();
    }


    private char[] add(char a, char b, char c) {
        char[] aArray = add(a, b);
        char value = aArray[1];
        char[] bArray = add(value, c);
        if (aArray[0] == '1' || bArray[0] == '1') {
            return new char[]{'1', bArray[1]};
        } else {
            return new char[]{'0', bArray[1]};
        }
    }


    private char[] add(char a, char b) {
        if (a == b) {
            if (a == '0') {
                return new char[]{'0', '0'};
            } else {
                return new char[]{'1', '0'};
            }
        } else {
            return new char[]{'0', '1'};
        }
    }

    private char getByIndex(String a, int index) {
        return index >= 0 && index < a.length() ? a.charAt(index) : '0';
    }

}
