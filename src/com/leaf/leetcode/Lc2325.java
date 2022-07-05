package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tongshujian
 * @date 2022/7/5
 */
public class Lc2325 {


    /**
     * 使用map 存储密钥字符对应关系
     * @param key
     * @param message
     * @return
     */
    public String decodeMessage(String key, String message) {
        List<Character> list = new ArrayList<>();
        Collections.addAll(list, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

        Map<Character, Character> map = new HashMap<>();

        char[] chars = key.toCharArray();

        for (char c : chars) {
            if (!map.containsKey(c) && c != ' ') {
                map.put(c, list.get(0));
                list.remove(0);
            }
        }

        char[] chars1 = message.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            chars1[i] = map.getOrDefault(chars1[i], ' ');
        }

        return new String(chars1);
    }

}
