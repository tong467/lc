package com.leaf.leetcode;

import java.util.*;

public class Lc676 {


    //["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//        [[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
    public static void main(String[] args) {
        MagicDictionaryOld magicDictionary = new MagicDictionaryOld();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}

class MagicDictionary {
    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }
}


class MagicDictionary2 {

    private char rootChar = '*';
    Tree root;
    List<List<Tree>> layer;


    public MagicDictionary2() {
        root = new Tree();
        root.c = rootChar;
        layer = new ArrayList<>();
        layer.add(Collections.singletonList(root));
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                Tree node = getTreeByChar(c, i);
                Tree parent;
                if (i == 0) {
                    parent = root;
                } else {
                    parent = getTreeByChar(str.charAt(i - 1), i - 1);
                }
                parent.children.add(node);
                node.parent.add(parent);
            }
            Tree tree = new Tree();
            tree.c = rootChar;
            getTreeByChar(str.charAt(str.length() - 1), str.length() - 1).children.add(tree);
        }
    }


    private Tree getTreeByChar(char c, int charIndex) {
        List<Tree> currentLayer;
        if (charIndex + 1 < layer.size()) {
            currentLayer = layer.get(charIndex + 1);
        } else {
            currentLayer = new ArrayList<>();
            layer.add(currentLayer);
        }
        for (Tree layerNode : currentLayer) {
            if (layerNode.c == c) {
                return layerNode;
            }
        }
        Tree node = new Tree();
        node.c = c;
        currentLayer.add(node);
        return node;
    }


    public boolean search(String searchWord) {
        Set<Tree> children = root.children;
        int jump = 0;
        boolean findOk;
        for (int i = 0; i < searchWord.length(); i++) {
            //单词长于字典树 返回 false
            if (children.size() == 1) {
                Object[] treeArray = children.toArray();
                Tree te1 = (Tree) treeArray[0];
                if (te1.c == rootChar) {
                    return false;
                }
            }
            char c = searchWord.charAt(i);
            findOk = false;
            for (Tree node : children) {
                if (node.c == c) {
                    findOk = true;
                    children = node.children;
                    break;
                }
            }
            //可以有一个字符不在字典树里面
            if (!findOk && jump == 0) {
                jump++;
                //循环下一次层字典树匹配结果
                List<Tree> TreeList = layer.get(i + 2);
                if (i + 1 < searchWord.length()) {
                    char c1 = searchWord.charAt(++i);
                    for (Tree tree : TreeList) {
                        if (c1 == tree.c) {
                            findOk = true;
                            children = tree.children;
                            break;
                        }
                    }
                } else {
                    //如果当前是最后1个字符那他的下层里必须有个结束字符
                    for (Tree tree : TreeList) {
                        if (rootChar == tree.c) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            if (!findOk) {
                return false;
            }
        }
        //下一层必须有结束字符
        for (Tree tree : children) {
            if (tree.c == rootChar) {
                return true;
            }
        }
        return false;
    }

    class Tree {
        public Tree() {
            children = new HashSet<>();
            parent = new HashSet<>();
        }

        private char c;
        private Set<Tree> children;

        private Set<Tree> parent;
    }
}


class MagicDictionaryOld {

    private String[] dictionary;


    public MagicDictionaryOld() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dictionary) {
            if (word.length() != searchWord.length()) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < searchWord.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                return true;
            }
        }

        return false;
    }
}
