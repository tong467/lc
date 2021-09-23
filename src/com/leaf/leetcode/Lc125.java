package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/6/22
 */
public class Lc125 {

    public static void main(String[] args) {
        System.out.println(new Lc125().isPalindrome("0P"));
    }


    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            //判断head是否是规范字符
            if (!isEffectiveChar(s.charAt(head))) {
                head++;
                continue;
            }
            //判断tail是否是规范字符
            if (!isEffectiveChar(s.charAt(tail))) {
                tail--;
                continue;
            }
            //判断head和tail忽略大小写是否相同
            if (s.charAt(head) == s.charAt(tail) ||
                    (isWord(s.charAt(head)) && isWord(s.charAt(tail)) &&
                            Math.abs(s.charAt(head) - s.charAt(tail)) == Math.abs('A' - 'a'))) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isEffectiveChar(char c) {
        if (isNumber(c) || isWord(c)) {
            return true;
        }
        return false;
    }

    private boolean isNumber(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }


    private boolean isWord(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
