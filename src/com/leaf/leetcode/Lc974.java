package com.leaf.leetcode;

/**
 * @author tongshujian
 * @date 2020/5/27
 */
public class Lc974 {


    public static void main(String[] args) {
        System.out.println(new Lc974().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }


    public int subarraysDivByK(int[] A, int K) {
        int resut = 0;
        int[] dp = new int[A.length];
        dp[0] = A[0] % K;
        if (dp[0] == 0) {
            resut++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] dp1 = new int[A.length];
            for (int j = 0; j <= i; j++) {
                dp1[j] = (dp[j] + A[i]) % K;
                if (dp1[j] == 0) {
                    resut++;
                }
            }
            dp = dp1;
        }

        return resut;

    }


    public int subarraysDivByK1(int[] A, int K) {
        int resut = 0;
        int[][] dp = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            dp[i][i] = A[i] % K;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = (dp[i - 1][j] + A[i]) % K;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 0) {
                    resut++;
                }
            }
        }

//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (dp[i][j] == 0) {
//                    resut++;
//                }
//            }
//        }

        return resut;

    }

}
