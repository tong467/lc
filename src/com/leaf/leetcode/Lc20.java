package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2019/12/26
 */
public class Lc20 {

    public static void main(String[] args) {

        System.out.println(ckeck("}"));

    }


    public static boolean ckeck(String str) {

        char[] aArray = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : aArray) {
            if (c == '(' || c == '[' || c == '{') {
                list.add(c);
            } else {
                if (list.size() == 0) {
                    return false;
                }
                char temp = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                if ((c == ']' && temp == '[') || (c == ')' && temp == '(') || (c == '}' && temp == '{')) {
                    continue;
                }
                return false;

            }
        }
        return !(list.size() > 0);
    }


}
