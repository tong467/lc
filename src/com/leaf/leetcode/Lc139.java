package com.leaf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/6/25
 */
public class Lc139 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("leet");
        list.add("code");
        System.out.println(new Lc139().wordBreak("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp(dp, i, s, wordDict);
        }
        return dp[s.length()];
    }

    private boolean dp(boolean[] dp, int end, String s, List<String> wordDict) {
        for (String str : wordDict) {
            if (str.length() > end) {
                continue;
            } else {
                if (s.substring(end - str.length(), end).equals(str) && dp[end - str.length()]) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> list = new HashSet<>();
        list.add(s);

        while (!list.isEmpty()) {
            Set<String> tempList = new HashSet<>();
            for (String word : wordDict) {
                for (String s1 : list) {
                    if (s1.indexOf(word) == 0) {
                        if (s1.length() == word.length()) {
                            return true;
                        }
                        tempList.add(s1.substring(word.length()));
                    }
                }
            }
            list = tempList;
        }
        return false;
    }
}
