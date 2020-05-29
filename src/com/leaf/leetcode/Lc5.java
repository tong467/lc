package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/21
 */
public class Lc5 {

    public static void main(String[] args) {
        System.out.println(new Lc5().longestPalindrome("1"));
    }

    public String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        int begin = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(max >s.length() - 1 - i + 1 ){
                break;
            }
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    int temp = j - i + 1;
                    if (temp > max) {
                        max = temp;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end+1);
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin <= end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }
}
