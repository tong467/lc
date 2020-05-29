package com.leaf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2020/5/20
 */
public class Lc1371 {

    public static void main(String[] args) {
        System.out.println(new Lc1371().findTheLongestSubstring(
                "leetcodeisgreat"));
    }


    public int findTheLongestSubstring(String s) {
        Integer flag = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(flag, -1);
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            switch (c) {
                case 'a':
                    flag ^= 1 << 4;
                    break;
                case 'e':
                    flag ^= 1 << 3;
                    break;
                case 'i':
                    flag ^= 1 << 2;
                    break;
                case 'o':
                    flag ^= 1 << 1;
                    break;
                case 'u':
                    flag ^= 1;
                    break;
            }
            if (!map.containsKey(flag)) {
                map.put(flag, j);
            } else {
                result = Math.max(result, j - map.get(flag));
            }
        }
        return result;
    }
}
