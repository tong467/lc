package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/5/28
 */
public class Lc8 {

    public static void main(String[] args) {
        System.out.println(new Lc8().myAtoi("-42"));
        long ans = 0;
        char c = '2';
        ans = ans * 10 + c - '0';

        System.out.println(new Lc8().myAtoi(" 0000000000012345678"));
    }

    private static Set<Character> numberSet = new HashSet<>();

    static {
        numberSet.add('1');
        numberSet.add('2');
        numberSet.add('3');
        numberSet.add('4');
        numberSet.add('5');
        numberSet.add('6');
        numberSet.add('7');
        numberSet.add('8');
        numberSet.add('9');
        numberSet.add('0');
    }


    public int myAtoi(String str) {
        boolean isfu = false;
        //去空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //去首符号
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            isfu = true;
            str = str.substring(1);
        }
        if (str.length() == 0) {
            return 0;
        }

        if (!numberSet.contains(str.charAt(0))) {
            return 0;
        }
        //去处首部0
        int k = 0;
        for (; k < str.length(); k++) {
            if (str.charAt(k) != '0') {
                break;
            }
        }
        str = str.substring(k);
        if (str.length() == 0) {
            return 0;
        }
        if (!numberSet.contains(str.charAt(0))) {
            return 0;
        }

        char[] cArray = new char[str.length() + 1];
        if (isfu) {
            str = "-" + str;
            cArray[0] = '-';
        } else {
            str = "+" + str;
            cArray[0] = '+';
        }

        int i = 1;
        for (; i < str.length(); i++) {
            if (!numberSet.contains(str.charAt(i)) || i > 12) {
                break;
            } else {
                cArray[i] = str.charAt(i);
            }
        }

        str = new String(cArray, 0, i);

        Long l = Long.parseLong(str);

        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return l.intValue();
        }
    }
}
