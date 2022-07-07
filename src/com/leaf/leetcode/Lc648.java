package com.leaf.leetcode;

import sun.text.normalizer.Trie;

import java.util.*;

public class Lc648 {

    public static void main(String[] args) {

        List<String> dictionary = new ArrayList<>();


        Collections.addAll(dictionary, "cat", "bat", "rat");
        System.out.println(new Lc648().replaceWords(dictionary, "the cattle was rattled by the battery"));
    }


    /**
     * hashmap 解法 ，将所有词根记录到hashSet 中，在将 sentence 按照" "分隔，逐个前缀比较Set中是否存在，存在就使用词根替换
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        dictionary.forEach(p -> set.add(p));
        String[] strArray = sentence.split(" ");
        for (int j = 0; j < strArray.length; j++) {
            for (int i = 1; i < strArray[j].length(); i++) {
                String prefix = strArray[j].substring(0, i);
                if (set.contains(prefix)) {
                    strArray[j] = prefix;
                    break;
                }
            }
        }
        return String.join(" ", strArray);
    }
}
