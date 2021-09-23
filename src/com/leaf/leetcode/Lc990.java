package com.leaf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/6/8
 */
public class Lc990 {

    public static void main(String[] args) {
        System.out.println(new Lc990().equationsPossible(new String[]{"b==b", "b==e", "e==c", "d!=e"}));
    }

    public boolean equationsPossible(String[] equations) {
//        Map<Character, Character> eSet = new HashMap<>();
//        Map<Character, Character> nESet = new HashMap<>();
//
//        for (String str : equations) {
//            char c1 = str.charAt(0);
//            char c2 = str.charAt(3);
//            if (c1 > c2) {
//                char temp = c1;
//                c1 = c2;
//                c2 = temp;
//            }
//            if (str.charAt(1) == '=') {
//                eSet.put(c1,c2);
//                if (nESet.contains(c2)) {
//                    return false;
//                }
//            } else {
//                eSet.add(c1);
//                nESet.add(c2);
//                if (eSet.contains(c2)) {
//                    return false;
//                }
//            }
//
//        }
        return true;
    }
}
