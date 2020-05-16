package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/4/23
 */
public class CoinLcc {

    public static void main(String[] args) {
        System.out.println(new CoinLcc().waysToChange(100));
    }

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        //哨兵处理边界情况 dp[1] = dp[1]+dp[0]
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
