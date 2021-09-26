package com.leaf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2019/12/20
 */
public class Lc171 {

    public static void main(String[] args) {
        System.out.println(new Lc171().titleToNumber("ZY"));
    }

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);

    }

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int reuslt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer value = map.get(chars[i]);
            Integer a = 1;
            for (int j = 0; j < s.length() - i - 1; j++) {
                a *= map.size();
            }
            reuslt = reuslt + value * a;
        }
        return reuslt;
    }
}
