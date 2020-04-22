package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongshujian
 * @date 2020/4/22
 */
public class Lc1021 {

    public static void main(String[] args) {
        System.out.println(new Lc1021().removeOuterParentheses("(()())(())"));
    }


    public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        List<Character> characterList = new ArrayList<>();
        int number = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                characterList.add(chars[i]);
                number++;
            } else {
                characterList.add(chars[i]);
                number--;
            }
            if (number == 0) {
                char[] temp = new char[characterList.size() - 2];
                for (int j = 1; j < characterList.size() - 1; j++) {
                    temp[j - 1] = characterList.get(j);
                }
                sb.append(new String(temp));
                characterList = new ArrayList<>();
            }
        }
        return sb.toString();
    }

}
