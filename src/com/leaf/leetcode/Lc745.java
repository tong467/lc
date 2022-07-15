package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Lc745 {
    public static void main(String[] args) {
        System.out.println(new WordFilter(new String[]{"kxeinco", "knepasg"}).f("kxeinco", "kxeinco"));
    }
}

class WordFilter {
    //前缀字典树
    private Trie prefTrie = new Trie();
    //后缀字典树
    private Trie suffTrie = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //构造前缀字典树
            Trie tempPrefTrie = prefTrie;
            for (int j = 0; j < word.length(); j++) {
                int charIndex = word.charAt(j) - 'a';
                if (tempPrefTrie.children[charIndex] == null) {
                    tempPrefTrie.children[charIndex] = new Trie();
                }
                tempPrefTrie = tempPrefTrie.children[charIndex];
                if (j == word.length() - 1) {
                    tempPrefTrie.index = i;
                }
            }
            //构造后缀字典树
            Trie tempSuffTrie = suffTrie;
            for (int j = word.length() - 1; j >= 0; j--) {
                int charIndex = word.charAt(j) - 'a';
                if (tempSuffTrie.children[charIndex] == null) {
                    tempSuffTrie.children[charIndex] = new Trie();
                }
                tempSuffTrie = tempSuffTrie.children[charIndex];
                if (j == 0) {
                    tempSuffTrie.index = i;
                }
            }
        }
    }

    public int f(String pref, String suff) {
        //匹配前缀
        Trie tempPrefTrie = prefTrie;
        for (int i = 0; i < pref.length(); i++) {
            int pCharIndex = pref.charAt(i) - 'a';
            if (tempPrefTrie.children[pCharIndex] != null) {
                tempPrefTrie = tempPrefTrie.children[pCharIndex];
            } else {
                return -1;
            }
        }
        //匹配后缀
        Trie tempSuffTrie = suffTrie;
        for (int i = pref.length() - 1; i >= 0; i--) {
            int pCharIndex = suff.charAt(i) - 'a';
            if (tempSuffTrie.children[pCharIndex] != null) {
                tempSuffTrie = tempSuffTrie.children[pCharIndex];
            } else {
                return -1;
            }
        }
        //遍历 tempPrefTrie 找到所有下标不为 -1的值；
        Set<Integer> prefset = new HashSet<>();
        findIndex(tempPrefTrie, prefset);
        //遍历 tempSuffTrie 找到所有下标不为 -1的值；
        Set<Integer> suffset = new HashSet<>();
        findIndex(tempSuffTrie, suffset);
        //找到交集最大值
        int index = -1;
        for (Integer i : prefset) {
            if (suffset.contains(i)) {
                index = Math.max(index, i);
            }
        }
        return index;
    }

    public void findIndex(Trie trie, Set<Integer> set) {
        if (trie.index != -1) {
            set.add(trie.index);
        }
        for (Trie trie1 : trie.children) {
            if (trie1 != null) {
                findIndex(trie1, set);
            }
        }
    }


    class Trie {
        public Trie() {
            index = -1;
            children = new Trie[26];
        }

        private Trie[] children;
        private int index;
    }
}

